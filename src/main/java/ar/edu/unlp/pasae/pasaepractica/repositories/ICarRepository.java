package ar.edu.unlp.pasae.pasaepractica.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.pasae.pasaepractica.entities.Car;

/**
 * @author Mat�as Beccaria
 *
 */
public interface ICarRepository extends JpaRepository<Car, String> {

	List<Car> findByPatente(String patente, Pageable pageable);
}