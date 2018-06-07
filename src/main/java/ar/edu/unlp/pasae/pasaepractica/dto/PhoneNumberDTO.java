package ar.edu.unlp.pasae.pasaepractica.dto;

public class PhoneNumberDTO {

	private long number;

	private long id;

	private PhoneNumberDTO() {

	}

	public PhoneNumberDTO(final long id, final long number) {
		this();
		setNumber(number);
		setId(id);
	}

	public long getId() {
		return id;
	}

	public Long getNumber() {
		return number;
	}

	public void setId(final long id) {
		this.id = id;
	}

	private void setNumber(final Long numero) {
		this.number = numero;
	}
}
