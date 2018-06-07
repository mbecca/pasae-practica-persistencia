package ar.edu.unlp.pasae.pasaepractica.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaepractica.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepractica.exceptions.PersonNotFoundException;
import ar.edu.unlp.pasae.pasaepractica.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PutMapping(path = "/add")
	public void add(@RequestBody @Valid final PersonDTO aPersonDTO) throws PersonNotFoundException {
		getPersonService().save(aPersonDTO);

	}

	private PersonService getPersonService() {
		return personService;
	}

	@GetMapping(path = "/list")
	public Collection<PersonDTO> list() {
		return getPersonService().list();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This person is not found in the system")
	@ExceptionHandler(PersonNotFoundException.class)
	public void personExceptionHandler() {
	}

}
