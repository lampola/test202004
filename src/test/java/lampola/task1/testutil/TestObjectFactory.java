package lampola.task1.testutil;

import lampola.task1.domain.Person;

public class TestObjectFactory {

	public static Person getTestPerson() {
		Person person = new Person();
		person.setSsn("123456-6789");
		person.setFirstName("Markus");
		person.setLastName("Lampola");
		return person;
	}
}
