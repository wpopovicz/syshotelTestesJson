/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.edu.br.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author popovicz
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, nullable = false, unique = true)
    private Long id;

    public enum StatusdaReserva {

        RESERVADO, VAGO, UTILIZANDO
    };
    private StatusdaReserva status;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Quarto quarto;

    private String dataDaReserva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusdaReserva getStatus() {
        return status;
    }

    public void setStatus(StatusdaReserva status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataDaReserva() {
        return dataDaReserva;
    }

    public void setDataDaReserva(String dataDaReserva) {
        this.dataDaReserva = dataDaReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", status=" + status + ", cliente=" + cliente + ", quarto=" + quarto + ", dataDaReserva=" + dataDaReserva + '}';
    }

    public Reserva() {
    }

}
