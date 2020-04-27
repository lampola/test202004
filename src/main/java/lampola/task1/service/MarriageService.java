package lampola.task1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lampola.task1.domain.Marriage;
import lampola.task1.domain.Person;
import lampola.task1.repository.MarriageRepository;
import lampola.task1.repository.PersonRepository;

@Service
public class MarriageService {
	
	private PersonRepository personRepository;
	private MarriageRepository marriageRepository;
	
	MarriageService(PersonRepository personRepository, MarriageRepository marriageRepository) {
		this.personRepository = personRepository;
		this.marriageRepository = marriageRepository;
	}
	
	@Transactional
	public Marriage create(Marriage marriage) {
		Person husband = personRepository.getBySsn(marriage.getHusbandSsn());
		Person wife = personRepository.getBySsn(marriage.getWifeSsn());
		marriage.setHusband(husband);
		marriage.setWife(wife);
		
		Marriage savedMarriage = marriageRepository.save(marriage);
		
		husband.getWives().add(savedMarriage);
		wife.getHusbands().add(savedMarriage);
		
		personRepository.save(husband);
		personRepository.save(wife);
		
		return savedMarriage;
	}
}
