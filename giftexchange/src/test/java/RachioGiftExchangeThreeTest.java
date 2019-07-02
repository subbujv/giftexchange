
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RachioGiftExchangeThreeTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void isValidRachioGiftExchangeThreeTest() {
		RachioGiftExchangeThree tester = new  RachioGiftExchangeThree();
		List<String> familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");
		familyMembers.add("Person2");
		familyMembers.add("Person3");
		familyMembers.add("Person4");


		Map<Integer,Map<String,String>> families = new HashMap<Integer,Map<String,String>>();
		Map<String,String> family1 =  new HashMap<String,String>();
		family1.put("Person1", "Person1");
		family1.put("Person2", "Person2");
		Map<String,String> family2 =  new HashMap<String,String>();
		family2.put("Person3", "Person3");
		family2.put("Person4", "Person4");


		families.put(0, family1);
		families.put(1, family2);
		Map<String, String> giftExhangers = tester.calculateGiftExchange(familyMembers,families);
		assertNotNull("gift exchangers is null ",giftExhangers);
		assertTrue(giftExhangers.size() ==4);
		assertTrue("gift exchangers keys in received map;", giftExhangers.keySet().containsAll(familyMembers));


		familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");
		familyMembers.add("Person2");
		familyMembers.add("Person3");
		families = new HashMap<Integer,Map<String,String>>();
		family1 =  new HashMap<String,String>();
		family1.put("Person1", "Person1");
		family1.put("Person2", "Person2");
		family2 =  new HashMap<String,String>();
		family2.put("Person3", "Person3");
		families.put(0, family1);
		families.put(1, family2);
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("No gift exchanger for 1 person.");
		giftExhangers = tester.calculateGiftExchange(familyMembers,families);


	}


}
