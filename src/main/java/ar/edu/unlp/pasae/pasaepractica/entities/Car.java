package ar.edu.unlp.pasae.pasaepractica.entities;

import javax.persistence.Entity;

@Entity
public class Car extends AbstractEntity {

	private String patente;

	private String marca;

	private String modelo;

	private String color;

	private Car() {
	}

	public Car(final String patente, final String marca, final String modelo, final String color) {
		this();
		setPatente(patente);
		setMarca(marca);
		setModelo(modelo);
		setColor(color);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}

	public String getColor() {
		return color;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPatente() {
		return patente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (color == null ? 0 : color.hashCode());
		result = prime * result + (marca == null ? 0 : marca.hashCode());
		result = prime * result + (modelo == null ? 0 : modelo.hashCode());
		result = prime * result + (patente == null ? 0 : patente.hashCode());
		return result;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public void setMarca(final String marca) {
		this.marca = marca;
	}

	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	public void setPatente(final String patente) {
		this.patente = patente;
	}

}
