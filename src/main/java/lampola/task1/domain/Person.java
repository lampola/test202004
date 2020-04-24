package lampola.task1.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter // Getters and setters are generated by Lombok
@Setter
public class Person extends AbstractPersistable<Long> {
	private String ssn;
	private String firstName;
	private String lastName;
}