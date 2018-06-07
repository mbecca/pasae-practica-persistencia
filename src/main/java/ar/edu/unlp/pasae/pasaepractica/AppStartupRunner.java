package ar.edu.unlp.pasae.pasaepractica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepractica.entity.Person;
import ar.edu.unlp.pasae.pasaepractica.entity.PhoneNumber;
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

		final Person mbecca = new Person("Matías", "Beccaria");
		final Person mbutti = new Person("Matías", "Butti");

		final Person lmessi = new Person("Lionel", "Messi");
		final Person ghiguain = new Person("Gonzalo", "Higuain");

		mbecca.addPhoneNumber(new PhoneNumber(1234));
		mbecca.addFriend(lmessi);
		mbecca.addFriend(ghiguain);

		mbutti.addFriend(ghiguain);

		getPersonRepository().save(lmessi);
		getPersonRepository().save(ghiguain);

		getPersonRepository().save(mbecca);
		getPersonRepository().save(mbutti);

	}

}