import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
 *After the third year of having the gift exchange, you’ve heard complaints of having the same gift
giver year after year. Modify your program so that a family member can only have the same Gift
Giver once every 3 years.
 */

public class RachioGiftExchangeTwo {

	public static void main(String[] args) {
		// get there year of gift exchange  as input from user
		int year =-1;
		if (args.length > 0)   { 
			RachioGiftExchangeTwo problem2 = new RachioGiftExchangeTwo();
			year =problem2.getYear(args[0]);
			if(year >0) {
				//Put all family members in here
				List<String> familyMembers = new ArrayList<String>();
				familyMembers.add("Person1");
				familyMembers.add("Person2");
				familyMembers.add("Person3");
				familyMembers.add("Person4");
				familyMembers.add("Person5");
				familyMembers.add("Person6");



				Map<String, String> giftExhangers =problem2.calculateGiftExchange(year,familyMembers);
				// Print gift giver to taker to Console

				for(Map.Entry<String, String> finalMap : giftExhangers.entrySet()) {
					System.out.println( finalMap.getKey() + " gives a gift to: " + finalMap.getValue());
				}
			}else {
				System.out.println("Please enter Year of gift exchange greater than 0"); 
			}
		} 
		else {
			System.out.println("Please enter Year of gift exchange greater than 0"); 
			return;
		} 

	}
	public  Map<String, String> calculateGiftExchange(int year,List<String> familyMembers) {
		Map<String, String> giftExhangers = new HashMap<String, String>();	
		List<Integer> used = new ArrayList<Integer>();
		int groupSize=familyMembers.size();
		Random rand = new Random(groupSize+(year%3)+10); 
		for(String person: familyMembers){

			int value  = rand.nextInt(groupSize);
			//if person hasn't been used before, if exchanger still need to be made, if user isn't assigned to themselves
			while(used.contains(value) && (giftExhangers.size() < groupSize || value == familyMembers.indexOf(person))){
				value = rand.nextInt(groupSize);
			}
			used.add(value);
			giftExhangers.put(person, familyMembers.get(value));
		}
		return giftExhangers;

	}
	//validate the gift exchange year
	private int getYear(String yearCount) {
		int year =-1;
		if(yearCount.matches("\\d+")) {
			year = Integer.parseInt(yearCount);

		}
		return year;
	}
}
