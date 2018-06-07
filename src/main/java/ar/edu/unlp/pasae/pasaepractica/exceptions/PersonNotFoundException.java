package ar.edu.unlp.pasae.pasaepractica.exceptions;

public class PersonNotFoundException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = -2747086196128977095L;

	public PersonNotFoundException() {

	}

	public PersonNotFoundException(final String message, final Exception exception) {
		super(message, exception);
	}

}
