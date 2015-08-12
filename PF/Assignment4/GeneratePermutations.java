/**
 * Find all possible permutation for string
 * @author Manish
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GeneratePermutations {

	public static void permuteString(String startString,
			String endingString, ArrayList<String> list) {
		//Base condition
		if (endingString.length() <= 1) {
			list.add(startString + endingString);
			System.out.println(startString + endingString);
		} else {
			for (int i = 0; i < endingString.length(); i++) {
				
				//take the new string to make permutation
				String newString = endingString.substring(0, i)
						+ endingString.substring(i + 1);
				
				//call the method permuteString
				permuteString(startString + endingString.charAt(i),
						newString, list);
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		sc.close();
		ArrayList<String> list = new ArrayList<String>();
		permuteString("", string, list);
		System.out.println("\n");
		//Print the combinations of string 
		Iterator<String> iterator = ((ArrayList<String>) list).iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
