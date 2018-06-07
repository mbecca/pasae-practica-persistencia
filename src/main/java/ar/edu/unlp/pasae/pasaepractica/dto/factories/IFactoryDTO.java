package ar.edu.unlp.pasae.pasaepractica.dto.factories;

import java.util.Collection;
import java.util.Set;

import ar.edu.unlp.pasae.pasaepractica.dto.BookDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PhoneNumberDTO;
import ar.edu.unlp.pasae.pasaepractica.entities.Book;
import ar.edu.unlp.pasae.pasaepractica.entities.Person;
import ar.edu.unlp.pasae.pasaepractica.entities.PhoneNumber;

/**
 * Clase que representa a la interfaz de la fábrica de DTO's
 *
 * @author mbecca
 *
 */
public interface IFactoryDTO {

	BookDTO convertToBookDTO(final Book book);

	Collection<BookDTO> convertToBookDTOs(final Set<Book> books);

	/**
	 * Convierte un objeto Persona en su correspondiente representación con DTO
	 *
	 * @author mbecca
	 *
	 */
	PersonDTO convertToPersonDTO(Person aPerson);

	/**
	 * Convierte una colección de objetos Persona en su correspondiente
	 * representación con DTO's
	 *
	 * @author mbecca
	 *
	 */
	Collection<PersonDTO> convertToPersonDTOs(Collection<Person> persons);

	PhoneNumberDTO convertToPhoneNumberDTO(final PhoneNumber telefono);

}
