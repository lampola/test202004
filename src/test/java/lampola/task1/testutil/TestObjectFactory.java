package lampola.task1.testutil;

import java.util.Date;

import lampola.task1.domain.Person;

public class TestObjectFactory {

	public static Person getTestPerson() {
		Person person = new Person();
		person.setSsn("123456-6789");
		person.setFirstName("Markus");
		person.setLastName("Lampola");
		person.setDateOfBirth(new Date(2020, 1, 31));
		return person;
	}
}
