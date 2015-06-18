package br.utfpr.edu.br.bean;

import br.utfpr.edu.br.bean.Reserva.StatusdaReserva;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, Cliente> cliente;
	public static volatile SingularAttribute<Reserva, Quarto> quarto;
	public static volatile SingularAttribute<Reserva, Long> id;
	public static volatile SingularAttribute<Reserva, String> dataDaReserva;
	public static volatile SingularAttribute<Reserva, StatusdaReserva> status;

}

