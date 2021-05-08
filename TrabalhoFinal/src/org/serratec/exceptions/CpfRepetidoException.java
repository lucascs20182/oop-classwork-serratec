package org.serratec.exceptions;

public class CpfRepetidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8121629630975497991L;

	public CpfRepetidoException() {
		super("Este CPF já foi cadastrado no sistema.");
	}
}
