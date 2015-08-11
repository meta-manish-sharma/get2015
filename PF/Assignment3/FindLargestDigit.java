/**
 * Find largest digit using recursion 
 * @author Manish
 *
 */
import java.util.Scanner;
public class FindLargestDigit {
	//this method find largest digit recursively 
	int largestDigit(int number,int maximum){
		
		//do operation until number not equal zero
		if(number!=0){
			//if digit is greater then copy in maximum
			if(maximum<number%10){
				maximum=number%10;
			}
			//divide the number by 10 and pass in the function
			return largestDigit(number/10,maximum);
		}
		else
			return maximum;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();//take input from user
		sc.close();//close the scanner object
		FindLargestDigit object=new FindLargestDigit();
		int remainder=object.largestDigit(number,0);
		System.out.println(remainder);

	}
}
