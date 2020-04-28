package lampola.task1.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import lampola.task1.domain.Marriage;
import lampola.task1.domain.Person;
import lampola.task1.repository.MarriageRepository;
import lampola.task1.repository.PersonRepository;
import lampola.task1.testutil.TestObjectFactory;

public class MarriageServiceTest {

	private PersonRepository personRepository = Mockito.mock(PersonRepository.class);
	private MarriageRepository marriageRepository = Mockito.mock(MarriageRepository.class);

	@Autowired
	private MarriageService marriageService;

	@Before
	public void setup() {
		this.marriageService = new MarriageService(personRepository, marriageRepository);
	}

	@Test
	public void testCreateMarriage() {
		Person person = TestObjectFactory.getTestPerson();
		Person spouse = TestObjectFactory.getTestSpouse();
		Marriage marriage = TestObjectFactory.getTestMarriage(person, spouse);
		
		when(marriageRepository.save(any(Marriage.class))).thenReturn(marriage);
		when(personRepository.getBySsn(person.getSsn())).thenReturn(person);
		when(personRepository.getBySsn(spouse.getSsn())).thenReturn(spouse);
		when(personRepository.save(person)).thenReturn(person);
		when(personRepository.save(spouse)).thenReturn(spouse);
		Marriage createdMarriage = marriageService.create(marriage);
		
		assertNotNull(createdMarriage.getHusbandSsn());
		assertNotNull(createdMarriage.getWifeSsn());
		assertNotNull(createdMarriage.getStarted());
	}

	@Test
	public void testAddChild() {
		Person father = TestObjectFactory.getTestPerson();
		Person mother = TestObjectFactory.getTestSpouse();
		Person child = TestObjectFactory.getTestChild();
		Marriage marriage = TestObjectFactory.getTestMarriage(father, mother);
		
		when(marriageRepository.getByHusbandAndWife(any(Person.class), any(Person.class))).thenReturn(marriage);
		when(personRepository.getBySsn(father.getSsn())).thenReturn(father);
		when(personRepository.getBySsn(mother.getSsn())).thenReturn(mother);
		when(personRepository.getBySsn(child.getSsn())).thenReturn(child);
		when(marriageRepository.save(any(Marriage.class))).thenReturn(marriage);
		Marriage updatedMarriage = marriageService.addChild(father.getSsn(), mother.getSsn(), child.getSsn());
		
		assertNotNull(updatedMarriage.getChildren());
	}
}
