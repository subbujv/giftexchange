
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class RachioGiftExchangeTwoTest {
	

	@Test
	public void isValidRachioGiftExchangeTwoTest() {
		List<String> familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");
		familyMembers.add("Person2");
		familyMembers.add("Person3");
		
		RachioGiftExchangeTwo tester = new  RachioGiftExchangeTwo();
			Map<String, String> giftExhangers1 =tester.calculateGiftExchange(1,familyMembers);
		assertNotNull("gift exchangers is null ",giftExhangers1);
		assertTrue(giftExhangers1.size() ==3);
		assertTrue("gift exchangers keys in received map;", giftExhangers1.keySet().containsAll(familyMembers));

	
		
		Map<String, String> giftExhangers2 =tester.calculateGiftExchange(2,familyMembers);
		Map<String, String> giftExhangers3 =tester.calculateGiftExchange(3,familyMembers);
		assertFalse(giftExhangers1.get("Person1").equals(giftExhangers2.get("Person1")));

		assertFalse(giftExhangers2.get("Person1").equals(giftExhangers3.get("Person1")));
		assertFalse(giftExhangers3.get("Person1").equals(giftExhangers1.get("Person1")));

		
		
	}

	
}
