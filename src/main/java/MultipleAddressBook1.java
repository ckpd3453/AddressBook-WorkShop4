import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook1 {

	static Person1 person;
	static Map<String, AddressBook1> multiList = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	/*
	 * Adding Multiple AddresBook
	 */
	public void shouldAddMultipleAddressBook() {
	
		System.out.print("Enter the name of AddressBook: ");
		String bookName = sc.next();
		if(multiList.containsKey(bookName))
		{
			System.out.println("Book Already Exist");
		}
		else {
			AddressBook1 service = new AddressBook1();
			multiList.put(bookName, service);
		}
		
	}
	
	/*
	 * Adding contacts to addressbook
	 */
	public void addingContacts() throws Exception {
		System.out.println("Enter name of Address Book: ");
		String finfBook = sc.next();
		AddressBook1 scr = multiList.get(finfBook);
		if(scr == null) {
			System.out.println("Book Not Exist");
		}else {
			scr.checkForDuplicate();
		}
	}
	
	/*
	 * to display addressbook
	 */
	public void displayBook() {
		for(String i : multiList.keySet()) {
			System.out.println(i);
			System.out.println(multiList.get(i).list);
		}
	}
	
}
