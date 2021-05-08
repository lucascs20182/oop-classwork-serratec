package org.serratec.exceptions;

public class DependenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8585784900840542874L;

	public DependenteException() {
		super("Dependente não pode ter mais do que 18 anos.");
	}
}
