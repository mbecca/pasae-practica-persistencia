package ar.edu.unlp.pasae.pasaepractica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepractica.entities.Book;
import ar.edu.unlp.pasae.pasaepractica.entities.Person;
import ar.edu.unlp.pasae.pasaepractica.entities.PhoneNumber;
import ar.edu.unlp.pasae.pasaepractica.repositories.IPersonRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private IPersonRepository personRepository;

	private IPersonRepository getPersonRepository() {
		return personRepository;
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {

		final Person mbecca = new Person("Mat�as", "Beccaria");
		final Person mbutti = new Person("Mat�as", "Butti");

		final Person lmessi = new Person("Lionel", "Messi");
		final Person ghiguain = new Person("Gonzalo", "Higuain");

		final Book book = new Book(1234, "UnNombre", mbecca);

		mbecca.addPhoneNumber(new PhoneNumber(1234));
		mbecca.addFriend(lmessi);
		mbecca.addFriend(ghiguain);
		mbecca.addBook(book);

		mbutti.addFriend(ghiguain);

		getPersonRepository().save(lmessi);
		getPersonRepository().save(ghiguain);

		getPersonRepository().save(mbecca);
		getPersonRepository().save(mbutti);

		// // Borrar un libro de la persona y que se borra en cascada el objeto libro
		// (orphanRemoval = true)
		// mbecca.removeBook(book);
		// getPersonRepository().save(mbecca);

		// // Borrar la persona y que se borren en cascada los libros
		// getPersonRepository().delete(mbecca);

		// // Borrar el n�mero de tel�fono de la persona y que se borra en cascada el
		// objeto PhoneNumber
		// (orphanRemoval = true)
		// mbecca.removePhoneNumber();
		// getPersonRepository().save(mbecca);
	}

}