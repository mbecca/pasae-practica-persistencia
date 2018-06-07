package ar.edu.unlp.pasae.pasaepractica.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Clase que representa a la entidad Persona
 *
 * @author mbecca
 *
 */
@Entity
public class Person extends AbstractEntity {

	public static final class PersonBuilder {

		private String name;

		private String surname;

		private Set<Person> friends;

		private PhoneNumber phoneNumber;

		private PersonBuilder() {
		}

		public PersonBuilder addFriends(final Set<Person> friends) {
			setFriends(friends);
			return this;
		}

		public PersonBuilder addName(final String name) {
			setName(name);
			return this;
		}

		public PersonBuilder addPhoneNumber(final PhoneNumber phoneNumber) {
			setPhoneNumber(phoneNumber);
			return this;
		}

		public PersonBuilder addSurname(final String surname) {
			setSurname(surname);
			return this;
		}

		public Person createPerson() {
			final Person person = new Person(getName(), getSurname());
			person.setPhoneNumber(getPhoneNumber());
			person.setFriends(getFriends());
			return person;

		}

		private Set<Person> getFriends() {
			return friends;
		}

		private String getName() {
			return name;
		}

		private PhoneNumber getPhoneNumber() {
			return phoneNumber;
		}

		private String getSurname() {
			return surname;
		}

		private void setFriends(final Set<Person> friends) {
			this.friends = friends;
		}

		private void setName(final String name) {
			this.name = name;
		}

		private void setPhoneNumber(final PhoneNumber phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		private void setSurname(final String surname) {
			this.surname = surname;
		}

	}

	public static final PersonBuilder builder() {
		return new PersonBuilder();
	}

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String name;

	@NotEmpty(message = "El apellido no puede ser nulo o vacío")
	private String surname;

	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Person> friends;

	@OneToOne(cascade = CascadeType.ALL)
	private PhoneNumber phoneNumber;

	private Person() {
		setFriends(new HashSet<>());
	}

	public Person(final String name, final String surname) {
		this();
		setName(name);
		setSurname(surname);
	}

	public boolean addFriend(final Person friend) {
		return getFriends().add(friend);
	}

	public void addPhoneNumber(final PhoneNumber phoneNumber) {
		setPhoneNumber(phoneNumber);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public Collection<Person> getFriends() {
		return friends;
	}

	public String getName() {
		return name;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (surname == null ? 0 : surname.hashCode());
		return result;
	}

	public boolean removeFriend(final Person friend) {
		return getFriends().remove(friend);
	}

	private void setFriends(final Set<Person> friends) {
		this.friends = friends;
	}

	private void setName(final String name) {
		this.name = name;
	}

	private void setPhoneNumber(final PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private void setSurname(final String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return getName() + "-" + getSurname();
	}
}
