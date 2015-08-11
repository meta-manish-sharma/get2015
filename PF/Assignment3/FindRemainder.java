/*
 * This program find recursively remainder between two integer numbers  
 * @author Manish
 */
public class FindRemainder {
	int getRemainder(int devident, int deviser){
		if(deviser!=0){			//handle deviser zero
			if(devident<deviser){ //base condition
				return devident;
			}
			else if(devident==deviser){ //base condition
				return 0;
			}
			else{
				return getRemainder(devident-deviser,deviser); //call function to reach near to base condition 
			}
		}
		else{
			System.out.println("Deviser could not be zero");
			return -1;
		}
	}

	public static void main(String[] args) {
		FindRemainder object=new FindRemainder();
		int remainder=object.getRemainder(100,3);
		System.out.println(remainder);

	}

}
