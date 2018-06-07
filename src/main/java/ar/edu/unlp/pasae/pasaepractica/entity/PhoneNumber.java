package ar.edu.unlp.pasae.pasaepractica.entity;

import javax.persistence.Entity;

@Entity
public class PhoneNumber extends AbstractEntity {

	private long numero;

	PhoneNumber() {

	}

	public PhoneNumber(final long numero) {
		this();
		setNumero(numero);
	}

	public Long getNumero() {
		return numero;
	}

	private void setNumero(final Long numero) {
		this.numero = numero;
	}
}
