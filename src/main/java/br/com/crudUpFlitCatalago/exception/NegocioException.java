package br.com.crudUpFlitCatalago.exception;

public class NegocioException extends RuntimeException {
	
	
	private static final long serialVersionUID = 3606162280279339305L;

	public NegocioException(String msg) {
		super(msg);
	}

}
