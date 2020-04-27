package lampola.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lampola.task1.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person getBySsn(String ssn);
}
