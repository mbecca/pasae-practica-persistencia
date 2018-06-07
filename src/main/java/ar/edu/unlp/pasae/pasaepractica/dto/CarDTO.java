package ar.edu.unlp.pasae.pasaepractica.dto;

public class CarDTO {

	private Long id;

	private String patente;

	private String marca;

	private String modelo;

	private String color;

	private CarDTO() {
	}

	public CarDTO(final Long id, final String patente, final String marca, final String modelo, final String color) {
		this();
		setId(id);
		setPatente(patente);
		setMarca(marca);
		setModelo(modelo);
		setColor(color);
	}

	public String getColor() {
		return color;
	}

	public Long getId() {
		return id;
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

	public void setColor(final String color) {
		this.color = color;
	}

	public void setId(final Long id) {
		this.id = id;
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
