package lampola.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lampola.task1.domain.Marriage;

public interface MarriageRepository extends JpaRepository<Marriage, Long> {

}
