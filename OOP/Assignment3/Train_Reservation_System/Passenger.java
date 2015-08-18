/**
 * This file have two types of class one for passenger and another for goods booking history. 
 * @author Manish 
 */
package Train_Reservation_System;

/*
 * this class stores the information about Passenger booking history.
 */
public class Passenger {
	
	String userName="";
	String trainNumber="";
	String ticketId="";
	String paymentId="";
	int nSeat=0;
	int totalAmount=0;
	public Passenger(String userName,String trainNumber,String ticketId,String paymentId,int nSeat,int totalAmount){
		this.userName=userName;
		this.trainNumber=trainNumber;
		this.nSeat=nSeat;
		this.totalAmount=totalAmount;
		this.ticketId=ticketId;
		this.paymentId=paymentId;
	}
}


/*
 * this class stores the information about Goods booking history.
 */
class Goods {
	
	String userName="";
	String trainNumber="";
	String ticketId="";
	String paymentId="";
	int nWeight=0;
	int totalAmount=0;
	public Goods(String userName,String trainNumber,String ticketId,String paymentId,int nWeight,int totalAmount){
		this.userName=userName;
		this.trainNumber=trainNumber;
		this.nWeight=nWeight;
		this.totalAmount=totalAmount;
		this.ticketId=ticketId;
		this.paymentId=paymentId;
	}
}
