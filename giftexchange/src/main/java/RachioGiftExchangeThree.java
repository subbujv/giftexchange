import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
As your extended family has grown, members have gotten married and/or had children. Those
families usually get gifts for members of their immediate family, so it doesn’t make sense for
anyone to be a Gift Giver for a member of their immediate family (spouse, parents, or children).
Modify your program to take this constraint into consideration when choosing Gift Givers.
 */

public class RachioGiftExchangeThree {

	public static void main(String[] args) {
	
			//Put all family members in here
			List<String> familyMembers = new ArrayList<String>();
			familyMembers.add("Person1");
			familyMembers.add("Person2");
			familyMembers.add("Person3");
			familyMembers.add("Person4");
			familyMembers.add("Person5");
			familyMembers.add("Person6");
			Map<Integer,Map<String,String>> families = new HashMap<Integer,Map<String,String>>();
			Map<String,String> family1 =  new HashMap<String,String>();
			family1.put("Person1", "Person1");
			family1.put("Person2", "Person2");
			Map<String,String> family2 =  new HashMap<String,String>();
			family2.put("Person3", "Person3");
			family2.put("Person4", "Person4");
			Map<String,String> family3 =  new HashMap<String,String>();
			family3.put("Person5", "Person5");
			family3.put("Person6", "Person6");
			families.put(0, family1);
			families.put(1, family2);
			families.put(2, family3);

			RachioGiftExchangeThree problem2 = new RachioGiftExchangeThree();
	
				Map<String, String> giftExhangers = problem2.calculateGiftExchange(familyMembers,families);

				// Print gift giver to taker to Console

				for(Map.Entry<String, String> finalMap : giftExhangers.entrySet()) {
					System.out.println( finalMap.getKey() + " gives a gift to: " + finalMap.getValue());
				}
			

	}
	public  Map<String, String> calculateGiftExchange(List<String> familyMembers,Map<Integer,Map<String,String>> families) {
		Map<String, String> giftExhangers = new HashMap<String, String>();	
		List<Integer> used = new ArrayList<Integer>();
		int groupSize=familyMembers.size();
		Random rand = new Random(); 
		
		for(String person: familyMembers){
			int counter=0;
			int value  = rand.nextInt(groupSize);
			//if person hasn't been used before, if exchanger still need to be made, if user isn't assigned to themselves
			while((used.contains(value) && giftExhangers.size() < groupSize || value == familyMembers.indexOf(person)) ||
					checkValidFamily(families,person,familyMembers.get(value)) ){
				counter++;
				value = rand.nextInt(groupSize);

				if(counter>groupSize) {
					throw new IllegalArgumentException("No gift exchanger for 1 person.");
				}
			}
			used.add(value);
			giftExhangers.put(person, familyMembers.get(value));
		}
		return giftExhangers;
	}
	//check if giver and taker are not from same family
	private boolean checkValidFamily(Map<Integer,Map<String,String>> families, String giftGiver, String giftTaker) {
		for(Map.Entry<Integer,Map<String,String>> finalMap : families.entrySet()) {
			if(finalMap.getValue().containsKey(giftGiver)  && finalMap.getValue().containsKey(giftTaker)) {
				return true;
			}
		}
		return false;
	}
	
}
