import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	// UC1
	static Scanner sc = new Scanner(System.in);
	static List<Person> list = new ArrayList<Person>();
	static Person person;

	// UC2
	public void addContact() {
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Enter City Name: ");
		String city = sc.next();
		System.out.println("Enter State Name: ");
		String state = sc.next();
		System.out.println("Enter Zip code: ");
		String zip = sc.next();
		System.out.println("Enter Phone Number: ");
		String phno = sc.next();
		System.out.println("Enter email address: ");
		String emailId = sc.next();
		if (list.size() > 0) {
			for (Person personList : list) {
				person = personList;
				if (firstName.equals(person.firstName)) {
					System.out.println("Person with name : " + person.firstName + " already exists!!!");
					break;
				}
			}
		} else {
			person = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
			list.add(person);
		}
	}

	public static void main(String[] args) {
		AddressBook add = new AddressBook();
		add.addContact();
	}

}
