package org.serratec.excecoes;

public class DependenteException extends Exception {
	public DependenteException() {
		super("Dependente n�o pode ter mais do que 18 anos.");
	}
}
