package StringDifference;

/**
 * @author Manish
 * StringTest showing performance difference StringBuffer and StringBuilder.
 * String is immutable object whereas StringBuffer and StringBulider are mutable objects.
 */
public class StringTest {

	public static void main(String[] args) {
		 
		long startTime = System.currentTimeMillis();
		String string = "Java";
		for (int i = 0; i < 1000; i++) {
			string+="C++";
		}
		System.out.println("Time taken by String: "
				+ (System.currentTimeMillis() - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		StringBuffer stringBuffer = new StringBuffer("Java");
		for (int i = 0; i < 1000000; i++) {
			stringBuffer.append("C++");
		}
		System.out.println("Time taken by StringBuffer: "
				+ (System.currentTimeMillis() - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("Java");
		for (int i = 0; i < 1000000; i++) {
			stringBuilder.append("C++");
		}
		System.out.println("Time taken by StringBuilder: "
				+ (System.currentTimeMillis() - startTime) + "ms");
		
	}

}
