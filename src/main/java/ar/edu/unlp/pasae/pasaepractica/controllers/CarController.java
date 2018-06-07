package ar.edu.unlp.pasae.pasaepractica.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaepractica.dto.CarDTO;
import ar.edu.unlp.pasae.pasaepractica.services.api.IAutoService;

@RestController
@RequestMapping("/auto")
public class CarController {

	@Autowired
	private IAutoService autoService;

	@GetMapping(path = "/findByPatente")
	public Collection<CarDTO> findByPatente(final String patente) {
		return getAutoService().findByPatente(patente);
	}

	private IAutoService getAutoService() {
		return autoService;
	}

}
