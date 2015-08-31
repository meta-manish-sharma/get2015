package GuestHouseAllocation;
/**
 * this class allocate room to guest by the age
 * @author Manish
 */
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class GuestHouseDemo {
	
//hash table contain room number as key and guest object as value	
public static Hashtable<Integer,Guest> guestRoomAllocation=new Hashtable<Integer, Guest>();

public static void main(String args[]){
	
	int roomNumber;
	Scanner sc=new Scanner(System.in);	
	//regular expression of positive number
	String regix="[0-9]+";
	 
	String numberOfRoom;
	
	 do{
		System.out.println("Enter no. of rooms");
		numberOfRoom=sc.next();
         
     }while(!(numberOfRoom.matches(regix)));
	 
	
	int noOfRoom=Integer.parseInt(numberOfRoom);
	while(true){
	System.out.println("\nPress 1 to Allocate the guest to Guest room");
	System.out.println("Press 2 to show guest room alloction");
	System.out.println("Press 3 to exit");
	
	String choice=sc.next();
	
	
	switch(choice){
	
	case "1":
		System.out.println("Enter guest name");
		String guestName=sc.next();
		
		
		String Age;
		
		do{
			System.out.println("Enter guest age");
			Age=sc.next();
	         
	     }while(!(Age.matches(regix)));
		
		int guestAge=Integer.parseUnsignedInt(Age);
		//creating guest object 
		Guest currentGuest=new Guest(guestAge,guestName);
		//calculating room number according to age
		roomNumber=guestAge%noOfRoom;
		
		while(!(guestRoomAllocation.get(roomNumber)==null)&&(roomNumber<noOfRoom)){
			
			roomNumber++;
		}
		
		
		if(roomNumber<noOfRoom){
			//allocating guest to room
			guestRoomAllocation.put(roomNumber,currentGuest);
				
		}
		else{
			
			roomNumber=0;
			
			while(!(guestRoomAllocation.get(roomNumber)==null)&&(roomNumber<=noOfRoom)){
				
				roomNumber++;
			}
			if(roomNumber<noOfRoom){
				//allocating guest to room
				guestRoomAllocation.put(roomNumber,currentGuest);
					
			}
			else{
				//if all rooms are occupied by guest
				System.out.println("\nSorry ! All Guest Rooms are Full\n");
					
			}
			
			
		}
			break;
			
	case "2":
		//displaying allocation of guest to room
		if(!(guestRoomAllocation.isEmpty())){
			//displaying allocation of guest to room
			for(Map.Entry<Integer,Guest>entry:guestRoomAllocation.entrySet()){
			       
			System.out.println("\nRoom no. "+entry.getKey()+"  is allocated to "+entry.getValue().name +", Age -"+entry.getValue().age );
			       
			}
			}else{
			System.out.println("\nCurrently Guest Rooms are not Allocated\n");
			}
			break;
		
	case "3":
		 System.exit(0);
		
	default: 	
		System.out.println("Please enter correct choice !");
		
	
	}
	
	
	}
	
	
}
	
	
	
}
