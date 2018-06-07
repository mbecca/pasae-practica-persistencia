package ar.edu.unlp.pasae.pasaepractica.dto.factories;

import java.util.Collection;
import java.util.List;

import ar.edu.unlp.pasae.pasaepractica.dto.CarDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.PhoneNumberDTO;
import ar.edu.unlp.pasae.pasaepractica.entity.Car;
import ar.edu.unlp.pasae.pasaepractica.entity.Person;
import ar.edu.unlp.pasae.pasaepractica.entity.PhoneNumber;

/**
 * Clase que representa a la interfaz de la f�brica de DTO's
 *
 * @author mbecca
 *
 */
public interface IFactoryDTO {

	CarDTO convertToAutoDTO(Car auto);

	Collection<CarDTO> convertToAutoDTOs(List<Car> patentes);

	/**
	 * Convierte un objeto Persona en su correspondiente representaci�n con DTO
	 *
	 * @author mbecca
	 *
	 */
	PersonDTO convertToPersonDTO(Person aPerson);

	/**
	 * Convierte una colecci�n de objetos Persona en su correspondiente
	 * representaci�n con DTO's
	 *
	 * @author mbecca
	 *
	 */
	Collection<PersonDTO> convertToPersonDTOs(Collection<Person> persons);

	PhoneNumberDTO convertToPhoneNumberDTO(final PhoneNumber telefono);

}
