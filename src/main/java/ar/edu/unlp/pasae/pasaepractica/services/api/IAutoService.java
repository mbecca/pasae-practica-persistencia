package ar.edu.unlp.pasae.pasaepractica.services.api;

import java.util.Collection;

import ar.edu.unlp.pasae.pasaepractica.dto.CarDTO;

public interface IAutoService {

	Collection<CarDTO> findByPatente(String patente);

}
