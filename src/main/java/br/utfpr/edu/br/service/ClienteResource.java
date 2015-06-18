/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.edu.br.service;

import br.utfpr.edu.br.bean.Cliente;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author popovicz
 */
@Path("/cliente")
public class ClienteResource {
    private static List<Cliente> clientes = new ArrayList<Cliente>();
    @GET
    @Produces("application/json")
    public List<Cliente> getClientes() {
        return new ArrayList<Cliente>(new Dao<Cliente>(Cliente.class).listaNova());
        //return new Cliente(1, "wil", "robinho", "carlos", "carloko");
    }

    @Path("/id{id}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente getClienteId(@PathParam("id") int id) {
        System.out.println(id);
        return new Cliente(1, "Robson", "robinho@gmail.com", "313213", "2123123");
        //return new ArrayList<Cliente>(new Dao<Cliente>(Cliente.class).listaPorId(id));
    }

    @Path("/{nome}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Cliente> getClienteName(@PathParam("name") String name) {
        System.out.println(name);
        return new ArrayList<Cliente>(new Dao<Cliente>(Cliente.class).listaPorNome(name));
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarCliente(@FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("rg") String rg,
            @FormParam("cpf") String cpf,
            @Context HttpServletResponse servletResponse) throws IOException {
        Cliente cliente = new Cliente();
        cliente.setName(name);
        cliente.setEmail(email);
        cliente.setRg(rg);
        cliente.setCpf(cpf);

        new Dao<Cliente>(Cliente.class).adiciona(cliente);
    }

    @PUT
    @Path("/{clienteId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("clienteId") int id, Cliente cliente) {
        clientes.set(id - 1, cliente);
        System.out.println(id);
        cliente.setId(clientes.indexOf(cliente) + 1);
        return Response.ok().build();
    }

    @DELETE
	public Response delete(@QueryParam("clienteId") int id) {
        //int id_cliente = Long.valueOf(id);
       // new Dao<Cliente>(Cliente.class).removePorId(id_cliente);
        if (id > clientes.size()) {
			throw new WebApplicationException(404);
		}

		clientes.remove(id - 1);
        return Response.ok().build();
    }

}
