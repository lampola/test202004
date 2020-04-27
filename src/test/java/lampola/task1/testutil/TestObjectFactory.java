package lampola.task1.testutil;

import java.util.ArrayList;
import java.util.Date;

import lampola.task1.domain.Marriage;
import lampola.task1.domain.Person;
import lampola.task1.enums.Sex;

public class TestObjectFactory {
	private static String HUSBAND_SSN = "123456-6789";
	private static String WIFE_SSN = "123456-9876";
	
	public static Person getTestPerson() {
		Person person = new Person();
		person.setSsn(HUSBAND_SSN);
		person.setFirstName("Markus");
		person.setLastName("Lampola");
		person.setDateOfBirth(new Date(1970, 1, 31));
		person.setSex(Sex.Male);
		person.setWives(new ArrayList<>());
		return person;
	}

	public static Person getTestSpouse() {
		Person person = new Person();
		person.setSsn(WIFE_SSN);
		person.setFirstName("Inkeri");
		person.setLastName("Lampola");
		person.setDateOfBirth(new Date(1980, 1, 31));
		person.setSex(Sex.Female);
		person.setHusbands(new ArrayList<>());
		return person;
	}
	
	public static Marriage getTestMarriage(Person husband, Person wife) {
		Marriage marriage = new Marriage();
		marriage.setHusbandSsn(HUSBAND_SSN);
		marriage.setWifeSsn(WIFE_SSN);
		marriage.setStarted(new Date(1999, 1, 31));
		return marriage;
	}
}
