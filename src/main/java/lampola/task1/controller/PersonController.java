package lampola.task1.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lampola.task1.domain.Person;
import lampola.task1.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;
	
	PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping(path = "/persons", consumes = "application/json", produces = "application/json")
	Person createPerson(@Valid @RequestBody Person person) {
		return personService.create(person);
	}
}
