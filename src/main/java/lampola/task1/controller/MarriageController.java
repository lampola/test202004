package lampola.task1.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lampola.task1.domain.Marriage;
import lampola.task1.domain.Person;
import lampola.task1.service.MarriageService;
import lampola.task1.service.PersonService;

@RestController
public class MarriageController {

	private MarriageService marriageService;
	
	MarriageController(MarriageService marriageService) {
		this.marriageService = marriageService;
	}

	@PostMapping(path = "/marriages", consumes = "application/json", produces = "application/json")
	Marriage create(@Valid @RequestBody Marriage marriage) {
		return marriageService.create(marriage);
	}
}
