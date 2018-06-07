package ar.edu.unlp.pasae.pasaepractica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unlp.pasae.pasaepractica.services.api.IPersonaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasaePracticaApplicationTests {

	@Autowired
	private IPersonaService personService;

	private IPersonaService getPersonService() {
		return personService;
	}

	@Test
	public void testAltaPersona() {
		// TODO hacer bien el test

	}

}
