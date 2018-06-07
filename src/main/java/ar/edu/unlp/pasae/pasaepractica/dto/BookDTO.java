package ar.edu.unlp.pasae.pasaepractica.dto;

public class BookDTO {

	private long isbn;

	private String name;

	private PersonDTO author;

	BookDTO() {

	}

	public BookDTO(final long isbn, final String name, final PersonDTO author) {
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
		final BookDTO other = (BookDTO) obj;
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

	public PersonDTO getAuthor() {
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

	public void setAuthor(final PersonDTO author) {
		this.author = author;
	}

	public void setIsbn(final long isbn) {
		this.isbn = isbn;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
