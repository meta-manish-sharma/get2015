/* 1 2 3 4 5 
 	 1 2 3 4 
       1 2 3 
         1 2 
           1
Implement this also as same modular approach that we have used in assignment 1 and write junit test cases for each modules..
 
 * */

public class CreatePattern {
	
	//This method return the number of spaces in each row
	String [] spaces(int row,int n){
		int position=1;
		String space []=new String[row];
		for(int i=1;i<row;i++){
			space[position]=" ";
			for(int j=1;j<i;j++){
				space[position]=space[position]+" ";
			}
			position++;
		}
		return space;
	}
	
	//This method return the number sequence in each row
	String [] numbers(int row,int n){
		String number[]=new String[row];
		for(int i=0;i<row;i++){
			 number[i]="1";
			for(int j=2;j<=n-i;j++){
				number[i]=number[i]+j;
			}
		}
		return number;
	}
	
	//This method return the whole pattern
	String [] printWholePyramid(String space[],String number[],int row){
		String pyramid[]=new String[row];
		pyramid[0]="";
		for(int i=0;i<row;i++){
			if(space[i]!=null)
			pyramid[i]=space[i];
			pyramid[i]+=number[i];
		}
		return pyramid;
	}

	public static void main(String[] args) {
		int row=5,n=5;						//row is used to specify the number of rows in pattern 
											//n used to specify the number till we want to print 
		CreatePattern pattern=new CreatePattern();
		String space[]=pattern.spaces(row, n);//Get the strings of spaces
		String number[]=pattern.numbers(row, n);//Get the strings of numbers
		String pyramid[]=pattern.printWholePyramid(space,number,row);
		for(int i=0;i<row;i++){
			System.out.println(pyramid[i]);
		}	
	}

}
