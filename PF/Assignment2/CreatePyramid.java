/**This code is used to print pattern like
 *   1
    121
   12321
  1234321
 123454321
12345654321
 123454321
  1234321
   12321
    121
     1

 * */
public class CreatePyramid {
	
	//This method return the number of spaces in each row
	String [] spaces(int row,int n){
		int mid=row/2,position=0;
		String space []=new String[row];
		for(int i=1;i<=n;i++){
			space[position]=" ";
			for(int j=i;j<n-1;j++){
				space[position]=space[position]+" ";
				}
			position++;
			}	
			space[mid]="";
		for(int i=n-1;i>=1;i--){
			space[position]=" ";
			for(int j=n-1;j>i;j--){
				space[position]=space[position]+" ";
				}
			position++;
			}		
	return 	space;
	}
	//This method return the number sequence in each row
	String [] numbers(int row,int n){
		String number[]=new String[row];
		int mid=row/2;
		for(int i=0;i<row;i++)
			number[i]="";
		for(int i=0,k=0;i<=mid;i++,k++){
			int temp=i+1;
			for(int j=1;j<=(i*2+1);j++){
					if(j<=(i+1))
						number[k]=number[k]+j;
					else{
						temp--;
						number[k]=number[k]+(temp);
						}
				}
			}
		
		for(int i=mid+1;i<row;i++){
				number[i]+=number[2*n -(i+2)];	
			}
		return number;
	}
	//This method return the whole pyramid
	String [] printWholePyramid(String space[],String number[],int row){
		String pyramid[]=new String[row];
		pyramid[0]="";
		for(int i=0;i<row;i++){
			pyramid[i]=space[i];
			pyramid[i]+=number[i];
		}
		return pyramid;
	}
	
	public static void main(String[] args) {
		int row=9,n=5;								//row is used to specify the number of rows in pattern 
													//n used to specify the number till we want to print 
		CreatePyramid createPyramid=new CreatePyramid();
		String space[]=createPyramid.spaces(row, n);//Get the strings of spaces
		String number[]=createPyramid.numbers(row, n);//Get the strings of numbers
		String patern[]=createPyramid.printWholePyramid(space,number,row);
		for(int i=0;i<row;i++){
			System.out.println(patern[i]);
		}

	}

}
