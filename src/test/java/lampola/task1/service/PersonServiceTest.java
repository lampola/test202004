package lampola.task1.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import lampola.task1.domain.Person;
import lampola.task1.repository.PersonRepository;
import lampola.task1.testutil.TestObjectFactory;

public class PersonServiceTest {

	private PersonRepository personRepository = Mockito.mock(PersonRepository.class);

	@Autowired
	private PersonService personService;

	@Before
	public void setup() {
		this.personService = new PersonService(personRepository);
	}

	@Test
	public void testCreatePerson() {
		Person person = TestObjectFactory.getTestPerson();
		when(personRepository.save(any(Person.class))).thenReturn(person);

		Person createdPerson = personService.createPerson(person);

		assertNotNull(createdPerson.getSsn());
		assertNotNull(createdPerson.getFirstName());
		assertNotNull(createdPerson.getLastName());
	}

}
