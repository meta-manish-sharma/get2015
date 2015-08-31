import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * this class find concordance of characters occurring in string
 * @author Manish
 *
 */
public class Concordance {
	
	// Main method
	public static void main(String[] args) {
		
		//stores in map concordance of characters occurring in string
		Map<Character, Set<Integer>> concordance = new HashMap<Character, Set<Integer>>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String");
		String input = scan.nextLine();		//take string from user
		
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			if (charAt == ' ') {				//skip space
				continue;
			}
			Set<Integer> set = concordance.get(charAt);
			if (set == null) {
				set = new HashSet<Integer>();	//create new set
			}
			set.add(i + 1);						//set char index in set
			concordance.put(charAt, set);		//put char entry in hashMap
		}
		
		//print hashMap entries
		for (Map.Entry m : concordance.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}
}
