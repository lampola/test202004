package lampola.task1.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lampola.task1.domain.Marriage;
import lampola.task1.service.MarriageService;

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

	@PostMapping(path = "/marriages/{fatherSsn}/spouses/{motherSsn}/children/{childSsn}", consumes = "application/json", produces = "application/json")
	Marriage addChild(@Valid 
			@PathVariable String fatherSsn,
			@PathVariable String motherSsn,
			@PathVariable String childSsn) {
		return marriageService.addChild(fatherSsn, motherSsn, childSsn);
	}
}
