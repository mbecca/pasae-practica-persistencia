package ar.edu.unlp.pasae.pasaepractica.exceptions;

public class UnexpectedException extends BaseException {

	private static final long serialVersionUID = 1L;

	public UnexpectedException(final String message, final Exception exception) {
		super(message, exception);
	}

}
