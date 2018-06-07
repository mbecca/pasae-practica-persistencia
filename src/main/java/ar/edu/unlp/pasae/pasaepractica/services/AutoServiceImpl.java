package ar.edu.unlp.pasae.pasaepractica.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaepractica.dto.CarDTO;
import ar.edu.unlp.pasae.pasaepractica.dto.factories.IFactoryDTO;
import ar.edu.unlp.pasae.pasaepractica.entities.Car;
import ar.edu.unlp.pasae.pasaepractica.repositories.ICarRepository;
import ar.edu.unlp.pasae.pasaepractica.services.api.IAutoService;

@Service
public class AutoServiceImpl implements IAutoService {

	@Autowired
	private ICarRepository autoRepository;

	@Autowired
	private IFactoryDTO factoryDTO;

	@Override
	public Collection<CarDTO> findByPatente(final String patente) {
		// index.max_result_window = 500 en este caso
		// https://www.elastic.co/guide/en/elasticsearch/guide/current/_fetch_phase.html
		final List<Car> autos = getAutoRepository().findByPatente(patente, PageRequest.of(0, 500));
		return getFactoryDTO().convertToAutoDTOs(autos);

	}

	private ICarRepository getAutoRepository() {
		return autoRepository;
	}

	private IFactoryDTO getFactoryDTO() {
		return factoryDTO;
	}

}
