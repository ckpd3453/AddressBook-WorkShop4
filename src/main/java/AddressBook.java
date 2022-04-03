import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBook {
	// Creating objects and arrayList
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> list = new ArrayList<Person>();
	static Person person;
	static AddressBook addressBook = new AddressBook();

	/*
	 * Checking for duplicate value
	 */
	public String checkForDuplicate() throws Exception {
		System.out.println("Enter First Name: ");
		String name = sc.next();
		if (name.matches("[A-z]{1}[a-z]{2,}")) {
		} else {
			System.out.println("Please Enter only Alphabets start with capital letter for name..");
			addressBook.checkForDuplicate();
		}
		if (list.size() > 0) {
			for (Person personList : list) {
				person = personList;
				if (name.equals(person.firstName)) {
					System.out.println(
							"Person with name : " + person.firstName + " already exists...\nPlease enter again..");
					addressBook.checkForDuplicate();

				} else {
					addressBook.addContact(name);
				}
			}
		} else {
			addressBook.addContact(name);
		}
		return name;
	}

	/*
	 * Adding Contacts in list and validating all the inputs given by user
	 * using @REGEX
	 */
	public ArrayList<Person> addContact(String name) throws Exception {
		MultipleAddressBook mult = new MultipleAddressBook();
		
		String firstName = name;
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		if (lastName.matches("[A-z]{1}[a-z]{2,}")) {
		} else {
			System.out.println(
					"Please Enter only Alphabets start with capital letter for last name.. \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter Address: ");
		String address = sc.next();
		if (address.matches("[A-z][a-z]*")) {
		} else {
			System.out.println("Please Enter only Alphabets to enter address.. \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter City Name: ");
		String city = sc.next();
		if (city.matches("[A-z][a-z]*")) {
		} else {
			System.out.println("Please Enter only Alphabets to enter city.. \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter State Name: ");
		String state = sc.next();
		if (state.matches("[A-z][a-z]*")) {
		} else {
			System.out.println("Please Enter only Alphabets to enter state.. \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter Zip code: ");
		String zip = sc.next();
		if (zip.matches("[0-9]{6}")) {
		} else {
			System.out.println("Please Enter 6 digit zip code \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter Phone Number: ");
		String phno = sc.next();
		if (phno.matches("[0-9]{10}")) {
		} else {
			System.out.println("Please Enter 10 digit phone no \n Please Refresh..");
			System.exit(0);
		}
		System.out.println("Enter email address: ");
		String emailId = sc.next();
		if (emailId.matches("([a-z]+[0-9]+@[a-z]{2,}[.]com)*")) {
		} else {
			System.out.println("Please Enter Email in abc235@bl.co.in format \n Please Refresh..");
			System.exit(0);
		}
		person = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
		list.add(person);
		System.out.println(list);
		return list;

	}

	//Getting Length of list
	public Integer length() {
		return addressBook.list.size();
	}

	/*
	 * Editing contacts by firstName
	 */
	public void editDetails() throws Exception {
		System.out.println("Enter first name: ");
		String fname = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFirstName().equals(fname)) {
				System.out.println(list.get(i));
				System.out.println(
						"Enter your choice to edit....\n1. FirstName\n2. LastName\n3. Address\n4. City\n5. State\n6. Zipcode\n7. PhoneNumber\n8. Email\n");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter new FirstName: ");
					String new_first_name = sc.next();
					list.get(i).setFirstName(new_first_name);

					break;
				case 2:
					System.out.println("Enter new LastName: ");
					String new_last_name = sc.next();
					list.get(i).setLastName(new_last_name);

					break;
				case 3:
					System.out.println("Enter new Address: ");
					String new_address = sc.next();
					list.get(i).setAddress(new_address);

					break;
				case 4:
					System.out.println("Enter new City Name: ");
					String new_city = sc.next();
					list.get(i).setCity(new_city);

					break;
				case 5:
					System.out.println("Enter new State Name: ");
					String new_state = sc.next();
					list.get(i).setState(new_state);

					break;
				case 6:
					System.out.println("Enter new Zip code: ");
					String new_zip = sc.next();
					list.get(i).setZip(new_zip);

					break;
				case 7:
					System.out.println("Enter new Phone Number: ");
					String new_phno = sc.next();
					list.get(i).setPhone(new_phno);

					break;
				case 8:
					System.out.println("Enter new email Id: ");
					String new_emailId = sc.next();
					list.get(i).setEmailId(new_emailId);

					break;
				default:
					System.out.println("Enter a valid choice");
					break;
				}
			} else {
				System.out.println("No Person Exist by this name...");
			}
		}
		System.out.println(list);
	}

	/*
	 * To Delete any contacts
	 */
	public void deleteContact() throws Exception {
		System.out.print("Enter the first name to delete: ");
		String dName = sc.next();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getFirstName().equalsIgnoreCase(dName)) {
					list.remove(i);
					System.out.println("Contact deleted...");
					System.out.println(list);
					break;
				}
			}
			System.out.println("...Contact not found!!!\n");
		} else {
			System.out.println("***Empty AddressBook***");
		}
	}
	
	/*
	 * To Find Contacts by name
	 */
	public void findContact()throws Exception {
		System.out.println("Enter the first name: ");
		String fName = sc.next();
		if(list.size()>0) {
			for(int i=0; i<=list.size(); i++) {
				if(list.get(i).getFirstName().equalsIgnoreCase(fName)) {
					System.out.println("Here is the Contact you are looking for :- \n"+list.get(i));
					break;
				}
			}
			System.out.println("...Contact not found!!!\n");
		}else {
			System.out.println("***Empty AddressBook***");
		}
	}

	/*
	 * Main Method
	 */
	public static void main(String[] args) throws Exception  {

		MultipleAddressBook mult = new MultipleAddressBook();
		System.out.println("Welcome to Address Book Program in AddressBook Main Class");
		try {
			while (true) {
				System.out.println(
						"Enter choice...\n1. Add new contact in AddressBook\n2. Edit existing details\n3. Delete existing details\n4. Find contact by name"
						+ "\n**********************************\n5. Add AddressBook \n6: Add Contact in AddressBook \n7: Display AddressBook");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the no of contacts want to add : ");
					int a = sc.nextInt();
					for (int i = 1; i <= a; i++) {
						addressBook.checkForDuplicate();
					}
					break;
				case 2:
					if (AddressBook.list.isEmpty()) {
						System.out.println("Address Book is empty..!!");
						break;
					} else {
						addressBook.editDetails();
						break;
					}
				case 3:
					if (AddressBook.list.isEmpty()) {
						System.out.println("Address Book is empty");
						break;
					} else {
						addressBook.deleteContact();
					}
					break;
				case 4:
					if (AddressBook.list.isEmpty()) {
						System.out.println("Address Book is empty");
						break;
					} else {
						addressBook.findContact();
					}
					break;
				case 5:
					mult.shouldAddMultipleAddressBook();
					break;
				case 6:
					mult.addingContacts();
					break;
				case 7:
					mult.displayBook();
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("\n                                 " + "????\n" + "                         "
					+ "****Insert Valid Input****");
		}
	}

}
