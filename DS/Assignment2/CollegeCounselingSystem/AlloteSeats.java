package CollegeCounselingSystem;
/**
 * this class allocate the seats of colleges to the students
 * according their rank 
 * @author Manish
 */

import java.util.Scanner;

public class AlloteSeats {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of students");
		int nstudent = sc.nextInt();
		
		//student choice according their rank 
		Queue studentQueue = new Queue(nstudent);	//students choice queue
		int scount=0,ccount=0;
		
		while(nstudent!=scount) {
			sc= new Scanner(System.in);
			System.out.println("Enter college name for rank "+(scount+1)+" student"); 
			studentQueue.enQueue(sc.next());		//college choice according student rank  
			scount++;
		}
		
		//college name and there seats store in list
		ArrayList college = new ArrayList();
		System.out.println("Enter number of colleges ");
		int ncollege = sc.nextInt();
		int cseats,nseats;
		String cname;
		while(ncollege!=ccount) {
			System.out.println("Enter name of college ");
			cname = sc.next();
			System.out.println("Enter number of seats in college ");
			nseats = sc.nextInt();
			cseats=0;
			while(cseats!=nseats) {
				college.add(cname);
				cseats++;
			}
			ccount++;
		}
	
		int i = 1;
		Object choice,allocateCollege;
		System.out.println("--------------College allocation chart---------------");
		while(college.size()!=0) {
			try {
			choice = studentQueue.deQueue();
			}
			catch(Exception e){
				break;
			}
			try {
				allocateCollege=college.remove(choice);
			}
			catch(Exception e) {
				allocateCollege=null;
			}
			if(allocateCollege!=null){
				System.out.println(i+" Rank student get "+allocateCollege+" college");
			}	
			i++;
		}
		
		System.out.println("Hard luck for remaining students try again");
		sc.close();
	}

}
