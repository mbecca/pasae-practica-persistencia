package ar.edu.unlp.pasae.pasaepractica.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.pasae.pasaepractica.entity.Person;

/**
 * Clase que representa a la interfaz de repositorio Persona. Se implementa con
 * Spring-Data
 */
public interface IPersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByNameAndSurname(String name, String surname);

	@Query("from Person where name=:name and surname=:surname")
	Optional<Person> findByNameAndSurname_(@Param("name") String name, @Param("surname") String surname);

	List<Person> findByNameStartingWithOrderBySurnameDesc(String prefix);

	@Query("from Person where name like :prefix% order by surname desc")
	List<Person> findByNameStartingWithOrderBySurnameDesc_(@Param("prefix") String prefix);

}
