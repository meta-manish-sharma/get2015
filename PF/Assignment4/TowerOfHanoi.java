/**
 * Find the solution of tower of hanoi for n disks
 * @author Manish
 */
import java.util.Scanner;

public class TowerOfHanoi {
	 
	//method to find solution for n disks tower of hanoi recursively
	 public static void towerOfHanoi(int nDisks, char from, char middle, char to,int array[],int lb,int ub) {
		    if (nDisks == 1){
		      System.out.println("Disk 1 from " + from + " to " + to);
		    }else {
		    		int mid=(lb+ub)/2;
		    		array[mid]=nDisks;
		    		
		    		//call tower of hanoi method for disk-1 and pass pegs as from, to, middle
		    		towerOfHanoi(nDisks - 1, from, to, middle,array,lb,mid-1);
		    		
		    		System.out.println("Disk " + nDisks + " from " + from + " to " + to);
		    		
		    		//call tower of hanoi method for disk-1 and pass pegs as  middle, from, to
		    		towerOfHanoi(nDisks - 1, middle, from, to,array,mid+1,ub);
		    }
		    
		    for(int i=0;i<array.length;i++){
		    	if(i%2==0){
		    		array[i]=1;
		    	}
		    }
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int nDisks;
		try{
			nDisks = sc.nextInt();
			int array[]=new int[(int) (Math.pow(2, nDisks)-1)];
			sc.close();
		    towerOfHanoi(nDisks, 'A', 'B', 'C',array,0,array.length);
		}catch(Exception e){
			System.out.println("Please enter valid input");
		}
		
	    
	}

}
