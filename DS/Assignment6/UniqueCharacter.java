import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * class has a method that takes a string and returns the number of unique characters in the string.
 * It is expected that a string with the same character sequence may be passed several times to the method.
 * Since the counting operation can be time consuming, the methods should cache the results,
 * so that when the methods is given a string previously encountered, it will simply retrieve the stored result.
 * Use collection and maps where appropriate.
 * @author Manish
 *
 */
public class UniqueCharacter {

	//map cache the unique string's unique characters
	static Map< String, Set<Character> > uniqueChar = new HashMap< String, Set<Character> >();
	
	//method find the unique character in string and store in map
	public static void getUniqueChar(String str) {
		String cacheStringSet = str; 
		//cacheStringSet.add(str);
		for(int i = 0 ; i < str.length() ; i++ ) {
			char charAt = str.charAt(i);
			if(charAt == ' ') {
				continue;
			}
			Set<Character> uniquecharSet = uniqueChar.get(str);
			if(uniquecharSet == null) {
				uniquecharSet = new HashSet<Character>();
			}
			uniquecharSet.add(charAt);
			uniqueChar.put(cacheStringSet, uniquecharSet);
		}
	}
	
	//Main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputString="";
		String choice;
		while(true){
			System.out.println("Enter 1 to put string");
			System.out.println("Enter 2 to find unique character");
			System.out.println("Enter 3 to exit");
			
			choice = scan.nextLine();
			switch(choice) {
				case "1" : System.out.println("Enter string");
							inputString = scan.nextLine();
							if(!(uniqueChar.containsKey(inputString))) {
								getUniqueChar(inputString);
							}	
							break;
				case "2" : System.out.println("---------Unique charecter for string---------"+uniqueChar);
						   System.out.println(uniqueChar.get(inputString));
							//
						   break;
				case "3" : return;
				default : System.out.println("Enter right choice");
			}
		}
	}

}
