/**
 * Find greatest common divisor using recursion 
 * @author Manish
 *
 */
public class FindGreatestCommonDevisor {
	
	int getGcd(int number1, int number2){
		
		//if number are equal then return any one number of them 
		if(number1==number2){
			return number1;
		}
		
		//if number1 is greater then call getGcd 
		//and pass difference between number instead of number1 
		else if(number1>number2){
			return getGcd(number1-number2,number2);
		}
		//if number2 is greater then call getGcd 
		//and pass difference between number instead of number2
		else if(number2>number1){
			return getGcd(number1,number2-number1);
		}
		else{
			//if number1 is zero then return number2
			if(number1==0)
				return number2;
			//if number2 is zero then return number1
			else if(number2==0)
				return number1;
			else
				return -1;
			
		}
	}
	public static void main(String[] args) {
		FindGreatestCommonDevisor object=new FindGreatestCommonDevisor();
		int gcd=object.getGcd(12,18);
		System.out.println(gcd);
		
	}

}
