
public class Assignment1 {
	int power(int i,int j){
		int result=i;
		if(j==0)
			return 1;
		else
		for(int temp=0;temp<j-1;temp++){
			result*=i;
		}
		return result;
	}
	int convertBinaryToOctal(int n){
		int octal=0,decimal=0,temporary=0;
		while(n!=0)
		{
			decimal+=n%10*this.power(2,temporary);
			++temporary;
			n/=10;
		}
		temporary=1;
		while(decimal!=0){
			octal+=(decimal%8)*temporary;
			decimal/=8;
			temporary*=10;
		}
		
		return octal;
	}
	public static void main(String args[]){
		Assignment1 assignment1=new Assignment1();
		int octal=assignment1.convertBinaryToOctal(110101);
		System.out.println(octal);
	}
}
