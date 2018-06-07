package ar.edu.unlp.pasae.pasaepractica.dto.factories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepractica.dto.BookDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PhoneNumberDTO;
import ar.edu.unlp.pasae.pasaepractica.entities.Book;
import ar.edu.unlp.pasae.pasaepractica.entities.Person;
import ar.edu.unlp.pasae.pasaepractica.entities.PhoneNumber;

/**
 * Clase que representa a la implementación de la fábrica de DTO's
 *
 * @author mbecca
 *
 */
@Component
public final class FactoryDTO implements IFactoryDTO {

	private static <A, R> Collection<R> createCollections(final Collection<A> col, final Function<A, R> function,
			final Collection<R> result) {
		col.stream().map(s -> function.apply(s)).forEach(result::add);
		return result;
	}

	@Override
	public BookDTO convertToBookDTO(final Book book) {
		final PersonDTO author = new PersonDTO(book.getAuthor().getId(), book.getAuthor().getName(),
				book.getAuthor().getSurname());
		return new BookDTO(book.getIsbn(), book.getName(), author);
	}

	@Override
	public Collection<BookDTO> convertToBookDTOs(final Set<Book> books) {
		return createCollections(books, this::convertToBookDTO, new ArrayList<>());
	}

	@Override
	public PersonDTO convertToPersonDTO(final Person aPerson) {
		final Set<PersonDTO> friendsDTO = new HashSet<>(convertToPersonDTOs(aPerson.getFriends()));
		final Set<BookDTO> booksDTO = new HashSet<>(convertToBookDTOs(aPerson.getBooks()));
		PhoneNumberDTO phoneNumberDTO = null;
		if (aPerson.getPhoneNumber() != null) {
			phoneNumberDTO = convertToPhoneNumberDTO(aPerson.getPhoneNumber());
		}
		return new PersonDTO(aPerson.getId(), aPerson.getName(), aPerson.getSurname(), phoneNumberDTO, friendsDTO,
				booksDTO);
	}

	@Override
	public Collection<PersonDTO> convertToPersonDTOs(final Collection<Person> persons) {
		return createCollections(persons, this::convertToPersonDTO, new ArrayList<>());
	}

	@Override
	public PhoneNumberDTO convertToPhoneNumberDTO(final PhoneNumber phoneNumber) {
		return new PhoneNumberDTO(phoneNumber.getId(), phoneNumber.getNumero());
	}

}
