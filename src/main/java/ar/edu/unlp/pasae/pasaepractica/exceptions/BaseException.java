package ar.edu.unlp.pasae.pasaepractica.exceptions;

public class BaseException extends Exception {

	private static final long serialVersionUID = -3171894213474333259L;

	public BaseException() {

	}

	public BaseException(final String message, final Exception exception) {
		super(message, exception);
	}

}
