package ar.edu.unlp.pasae.pasaepractica.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

/**
 * Clase que representa al DTO de la Persona
 *
 * @author mbecca
 *
 */
public class PersonDTO {

	private Long id;
	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String name;
	@NotEmpty(message = "El apellido no puede ser nulo o vacío")
	private String surname;

	private Set<PersonDTO> friends;

	private PhoneNumberDTO phoneNumber;

	private Set<BookDTO> books;

	private PersonDTO() {
		setFriends(new HashSet<>());
	}

	public PersonDTO(final Long id, final String name, final String surname) {
		this();
		setId(id);
		setName(name);
		setSurname(surname);
	}

	public PersonDTO(final Long id, final String name, final String surname, final PhoneNumberDTO phoneNumber,
			final Set<PersonDTO> friends) {
		this();
		setId(id);
		setName(name);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
		setFriends(friends);
	}

	public PersonDTO(final Long id, final String name, final String surname, final PhoneNumberDTO phoneNumber,
			final Set<PersonDTO> friends, final Set<BookDTO> books) {
		this();
		setId(id);
		setName(name);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
		setFriends(friends);
		setBooks(books);
	}

	public Set<BookDTO> getBooks() {
		return books;
	}

	public Set<PersonDTO> getFriends() {
		return friends;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PhoneNumberDTO getPhoneNumber() {
		return phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setBooks(final Set<BookDTO> books) {
		this.books = books;
	}

	public void setFriends(final Set<PersonDTO> friends) {
		this.friends = friends;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPhoneNumber(final PhoneNumberDTO phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

}
