package br.utfpr.edu.br.bean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> rg;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, String> email;

}

