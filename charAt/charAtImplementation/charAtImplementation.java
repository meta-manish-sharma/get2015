package charAtImplementation;

public class charAtImplementation {
	static String str = "Manish Sharma";
	public static void main(String[] args) {
		char output = charAt(5);
		System.out.println(output);
	}

	public static char charAt(int index) {
		char arrayString[] = str.toCharArray();
		if(index < 0 || index > arrayString.length){
			throw new StringIndexOutOfBoundsException();
		}
		return arrayString[index] ;
	}

}
