package ar.edu.unlp.pasae.pasaepractica.services.api;

import java.util.Collection;

import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.exceptions.BaseException;
import ar.edu.unlp.pasae.pasaepractica.exceptions.PersonNotFoundException;

/**
 * Clase que representa a la interfaz del servicio Persona
 *
 * @author mbecca
 *
 */
public interface IPersonaService {

	/**
	 * Borra una persona para el id dado.
	 *
	 * @author mbecca
	 *
	 */
	void delete(Long id);

	/**
	 * Devuelve una persona para el id dado.
	 *
	 * @author mbecca
	 *
	 */
	PersonDTO findById(Long id);

	PersonDTO findByNameAndSurname(String name, String surname) throws PersonNotFoundException;

	Collection<PersonDTO> findByNameStartingWithOrderByNameDesc(String prefix) throws PersonNotFoundException;

	/**
	 * Devuelve una colección con todas las personas de la aplicacióm.
	 *
	 * @author mbecca
	 *
	 */
	Collection<PersonDTO> list();

	/**
	 * Guarda una persona con los atributos dados.
	 *
	 * @param name
	 *            Nombre de la nueva persona
	 * @param surname
	 *            Apellido de la nueva persona.
	 * @author mbecca
	 * @throws PersonNotFoundException
	 *
	 */
	void save(PersonDTO personDTO) throws PersonNotFoundException;

	void thowException() throws BaseException;

}
