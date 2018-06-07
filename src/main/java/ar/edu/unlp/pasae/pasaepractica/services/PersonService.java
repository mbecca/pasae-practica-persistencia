package ar.edu.unlp.pasae.pasaepractica.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.factories.IFactoryDTO;
import ar.edu.unlp.pasae.pasaepractica.entities.Person;
import ar.edu.unlp.pasae.pasaepractica.entities.PhoneNumber;
import ar.edu.unlp.pasae.pasaepractica.entities.Person.PersonBuilder;
import ar.edu.unlp.pasae.pasaepractica.exceptions.PersonNotFoundException;
import ar.edu.unlp.pasae.pasaepractica.repositories.IPersonRepository;
import ar.edu.unlp.pasae.pasaepractica.services.api.IPersonaService;

/**
 * Clase que representa a la implemetación del servicio Persona
 *
 * @author mbecca
 *
 */
@Service
public class PersonService implements IPersonaService {

	@Autowired
	private IPersonRepository personRepository;

	@Autowired
	private IFactoryDTO factoryDTO;

	@Override
	public void delete(final Long id) {
		getPersonRepository().deleteById(id);
	}

	@Override
	public PersonDTO findById(final Long id) {
		final Optional<Person> aOptionalPerson = getPersonRepository().findById(id);
		final Person aPerson = aOptionalPerson.get();
		return getFactoryDTO().convertToPersonDTO(aPerson);
	}

	@Override
	public PersonDTO findByNameAndSurname(final String name, final String surname) throws PersonNotFoundException {
		final Optional<Person> aOptionalPerson = getPersonRepository().findByNameAndSurname(name, surname);
		final Person aPerson = aOptionalPerson.orElseThrow(PersonNotFoundException::new);
		return getFactoryDTO().convertToPersonDTO(aPerson);
	}

	@Override
	public Collection<PersonDTO> findByNameStartingWithOrderByNameDesc(final String prefix)
			throws PersonNotFoundException {
		final List<Person> list = getPersonRepository().findByNameStartingWithOrderBySurnameDesc(prefix);
		return getFactoryDTO().convertToPersonDTOs(list);
	}

	private Set<Person> findPersons(final Set<PersonDTO> personsDTO) throws PersonNotFoundException {
		final Set<Person> friends = new HashSet<>();
		for (final PersonDTO dto : personsDTO) {
			final Optional<Person> optional = getPersonRepository().findById(dto.getId());
			final Person person = optional.orElseThrow(PersonNotFoundException::new);
			friends.add(person);
		}
		return friends;
	}

	private IFactoryDTO getFactoryDTO() {
		return factoryDTO;
	}

	private IPersonRepository getPersonRepository() {
		return personRepository;
	}

	@Override
	public Collection<PersonDTO> list() {
		final List<Person> persons = getPersonRepository().findAll();
		return getFactoryDTO().convertToPersonDTOs(persons);

	}

	@Override
	public void save(final PersonDTO personaDTO) throws PersonNotFoundException {

		final PersonBuilder personBuilder = Person.builder();
		personBuilder.addName(personaDTO.getName());
		personBuilder.addSurname(personaDTO.getSurname());

		// Se obtiene la collección de amigos
		final Set<Person> friends = findPersons(personaDTO.getFriends());
		personBuilder.addFriends(friends);

		final PhoneNumber phoneNumber = new PhoneNumber(personaDTO.getPhoneNumber().getNumber());
		personBuilder.addPhoneNumber(phoneNumber);

		final Person person = personBuilder.createPerson();

		getPersonRepository().save(person);

	}

}
