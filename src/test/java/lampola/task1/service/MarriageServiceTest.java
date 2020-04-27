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
}
