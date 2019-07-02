import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
 * Imagine that every year your extended family does a gift exchange. For this gift exchange, each
person draws another person at random and then gets a gift for them (obviously, a person
cannot be their own gift exchanger). Write a program that will choose a Gift Giver for everyone
given a list of all the members of your extended family.
 */

public class RachioGiftExchangeOne {

	public static void main(String[] args) {

		//Put all family members in here
		List<String> familyMembers = new ArrayList<String>();
		familyMembers.add("Person1");
		familyMembers.add("Person2");
		familyMembers.add("Person3");
		familyMembers.add("Person4");
		familyMembers.add("Person5");

		RachioGiftExchangeOne problem1 = new RachioGiftExchangeOne();
		Map<String, String> giftExhangers =problem1.calculateGiftExchange(familyMembers);
		// Print gift giver to taker to Console

		for(Map.Entry<String, String> finalMap : giftExhangers.entrySet()) {
			System.out.println( finalMap.getKey() + " gives a gift to: " + finalMap.getValue());
		}
	}

	public Map<String, String>  calculateGiftExchange(List<String> familyMembers){
		Map<String, String> giftExhangers = new HashMap<String, String>();	
		if(familyMembers.size() <2) {
			throw new IllegalArgumentException ( "There should be atleast 2 people");
		}
		List<Integer> used = new ArrayList<Integer>();
		int groupSize=familyMembers.size();
		Random rand = new Random(); 

		for(String person: familyMembers){
			int value  = rand.nextInt(groupSize);
			//if person hasn't been used before, if exchanger still need to be made, if user isn't assigned to themselves
			while(used.contains(value) && giftExhangers.size() < groupSize || value == familyMembers.indexOf(person)){
				value = rand.nextInt(groupSize);
			}
			used.add(value);
			giftExhangers.put(person, familyMembers.get(value));
		}

		return giftExhangers;		

	}

}
