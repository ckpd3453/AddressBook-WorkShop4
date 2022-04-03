import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {

	@Before
	public void welcomeMessage() {
		System.out.println("Well-Come to your AddressBook");
	}
	
	@Test
	public void test() throws Exception {
		AddressBook addressBook  = new AddressBook();
		addressBook.checkForDuplicate();
		int length = addressBook.length();
		Assert.assertEquals(1, length);
	}

}
