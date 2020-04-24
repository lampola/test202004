package lampola.task1.service;

import org.springframework.stereotype.Service;

import lampola.task1.domain.Person;
import lampola.task1.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
}
