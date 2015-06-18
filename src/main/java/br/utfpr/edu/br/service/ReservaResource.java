/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.edu.br.service;

import br.utfpr.edu.br.bean.Cliente;
import br.utfpr.edu.br.bean.Quarto;
import br.utfpr.edu.br.bean.Reserva;
import br.utfpr.edu.br.conexao.Dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author popovicz
 */
@Path("/reserva")
public class ReservaResource {

    @GET
    @Produces("text/xml")
    public List<Reserva> getReservas() {
        return new ArrayList<Reserva>(new Dao<Reserva>(Reserva.class).listaTodos());
    }

    @Path("{id}")
    @GET
    @Produces("text/xml")
    public List<Reserva> getReservaId(@PathParam("id") Long id) {
        return new ArrayList<Reserva>(new Dao<Reserva>(Reserva.class).listaPorId(id));
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void adicionarReserva(@FormParam("id_cliente") Long id_cliente,
            @FormParam("id_quarto") Long id_quarto,
            @FormParam("data") String data,
            @Context HttpServletResponse servletResponse) throws IOException {

        Cliente cliente = new Dao<Cliente>(Cliente.class).buscaPorId(id_cliente);
        Quarto quarto = new Dao<Quarto>(Quarto.class).buscaPorId(id_quarto);

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setQuarto(quarto);
        reserva.setDataDaReserva(data);

        new Dao<Reserva>(Reserva.class).adiciona(reserva);
    }

    @Path("{id}")
    @PUT
    @Consumes("text/xml")
    @Produces("text/plain")
    public String atualizaReserva(Reserva reserva, @PathParam("id") int id) {
        return " atualizada.";
    }

    @Path("{id}")
    @DELETE
    @Produces("text/plain")
    public String removeReserva(@PathParam("id") int id) {
        Long id_reserva = Long.valueOf(id);
        new Dao<Reserva>(Reserva.class).removePorId(id_reserva);
        return "Reserva removida.";
    }

}
