package lampola.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lampola.task1.domain.Marriage;
import lampola.task1.domain.Person;

public interface MarriageRepository extends JpaRepository<Marriage, Long> {
	Marriage getByHusbandAndWife(Person husband, Person wife);
}
