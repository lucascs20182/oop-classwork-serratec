package org.serratec.excecoes;

public class DependenteException extends Exception {
	public DependenteException() {
		super("Todo dependente tem que ser menor que 18 anos.");
	}
}
