
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RachioGiftExchangeOneTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();


	@Test
	public void isValidRachioGiftExchangeOneTest() {
		List<String> familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");
		familyMembers.add("Person2");

		RachioGiftExchangeOne tester = new  RachioGiftExchangeOne();
		Map<String, String> giftExhangers =tester.calculateGiftExchange(familyMembers);
		assertNotNull("gift exchangers is null ",giftExhangers);
		assertTrue(giftExhangers.size() ==2);
		assertTrue("gift exchangers keys in received map;", giftExhangers.keySet().containsAll(familyMembers));

		
		
		familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");

		tester = new  RachioGiftExchangeOne();
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("There should be atleast 2 people");

		giftExhangers =tester.calculateGiftExchange(familyMembers);



	}


}
