package br.utfpr.edu.br.bean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Quarto.class)
public abstract class Quarto_ {

	public static volatile SingularAttribute<Quarto, String> custo;
	public static volatile SingularAttribute<Quarto, String> nome;
	public static volatile SingularAttribute<Quarto, Long> id;

}

