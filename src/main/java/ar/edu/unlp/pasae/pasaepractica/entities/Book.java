package ar.edu.unlp.pasae.pasaepractica.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Book extends AbstractEntity {

	private long isbn;

	private String name;

	@ManyToOne
	private Person author;

	Book() {

	}

	public Book(final long isbn, final String name, final Person author) {
		this();
		setIsbn(isbn);
		setName(name);
		setAuthor(author);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn != other.isbn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person getAuthor() {
		return author;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (author == null ? 0 : author.hashCode());
		result = prime * result + (int) (isbn ^ isbn >>> 32);
		result = prime * result + (name == null ? 0 : name.hashCode());
		return result;
	}

	private void setAuthor(final Person author) {
		this.author = author;
	}

	private void setIsbn(final long isbn) {
		this.isbn = isbn;
	}

	private void setName(final String name) {
		this.name = name;
	}

}
