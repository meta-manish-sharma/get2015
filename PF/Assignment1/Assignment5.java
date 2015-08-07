
public class Assignment5 {
	
	int checkSortedArray(int input[]){
		int output=0,size=input.length;
		if(input[0]<input[1]){
			for(int i=1;i<size;i++)
			{
				if(input[i-1]<input[i]){
					output=1;
				}
				else
					return 0;
			}
		}
		else{
			for(int i=1;i<size;i++){
				if(input[i-1]>input[i]){
					output=2;
				}
				else
					return 0;
			}
		}
			return output;
	}
			

	public static void main(String[] args) {
		Assignment5 assignment5=new Assignment5();
		int input[]={10,9,8};
		int output=assignment5.checkSortedArray(input);
			System.out.println(" "+output);

	}

}
