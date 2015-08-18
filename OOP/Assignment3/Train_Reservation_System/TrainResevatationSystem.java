/**
 * This class have the whole functionality of train reservation system  
 * @author Manish 
 */
package Train_Reservation_System;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 *this class use for book tickets  
 */
public class TrainResevatationSystem {
	
	ArrayList<Train> ptrain = new ArrayList<Train>();
	ArrayList<Train> gtrain = new ArrayList<Train>();
	static ArrayList<Passenger> passenger = new ArrayList<Passenger>();
	static ArrayList<Goods> goods = new ArrayList<Goods>();
	ArrayList<Payment> payment = new ArrayList<Payment>();
	Iterator<Train> iteratorPtrain;
	Iterator<Train> iteratorGtrain;
	static Iterator<Passenger> iteratorPassenger;
	static Iterator<Goods> iteratorGoods;
	Train tPassenger;
	Train tGoods;
	Passenger passe;
	Goods good;
	Payment pay;
	int count=0;
	Scanner scanner;
	
	//this method is shows the train chart  
	void showTrainChart(String type){
		//this shows passenger train chart
		if(type.equalsIgnoreCase("p")){
			iteratorPtrain = ((ArrayList<Train>) ptrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Seats");
			while (iteratorPtrain.hasNext()) {
				Train tobject = iteratorPtrain.next();
				System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
			}		
		}
		//this shows goods train chart
		else{
			iteratorGtrain = ((ArrayList<Train>) gtrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Weight");
			while (iteratorGtrain.hasNext()) {
				Train tobject = iteratorGtrain.next();
				System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
			}
		}
	}
	
	//this method read data from file
	void getTrainChart() throws IOException{
		
		try {
			StringTokenizer stringTokenizer;
			FileInputStream fin = new FileInputStream(new File("C:\\Users\\Manish\\workspace\\OOP_Assignment3\\src\\Train_Reservation_System\\train.txt"));
			DataInputStream in = new DataInputStream(fin);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String trainData="";
			int i=1;
			String trainType="",trainId="",time="",fare="",route="",capacity="";
			while ((trainData = br.readLine()) != null) {
				stringTokenizer = new StringTokenizer(trainData,","); 
				 i=1;
				 while (stringTokenizer.hasMoreTokens()) {  
			         if(i==1){  
			        	 trainType=stringTokenizer.nextToken();
			         }
			         else if(i==2){
			        	 trainId=stringTokenizer.nextToken();
			         }
			         else if(i==3){
			        	 time=stringTokenizer.nextToken();
			         }
			         else if(i==4){
			        	 fare=stringTokenizer.nextToken();
			         }
			         else if(i==5){
			        	 route=stringTokenizer.nextToken();
			         }else {
			        	 capacity=stringTokenizer.nextToken();
			         }
			        	i++; 
			     }
				int f=Integer.parseInt(fare);
				int c=Integer.parseInt(capacity);
				if(trainType.equalsIgnoreCase("P")){
					tPassenger=new Ptrain(trainType,trainId,time,f,route,c);
					ptrain.add(tPassenger);
				}
				else{
					tGoods=new Gtrain(trainType,trainId,time,f,route,c);
					gtrain.add(tGoods);
				}
				
				
			}
			
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//this method allocate ticket to user
	void allocateTicket(String name,String type){
		String train_Number;
		int n_Ticket=0;
		int n_Weight=0;
		if(type.equalsIgnoreCase("p")){
			iteratorPtrain = ((ArrayList<Train>) ptrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Seats");
			while (iteratorPtrain.hasNext()) {
				Train tobject = iteratorPtrain.next();
				System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
			}		
		}
		else{
			iteratorGtrain = ((ArrayList<Train>) gtrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Weight");
			while (iteratorGtrain.hasNext()) {
				Train tobject = iteratorGtrain.next();
				System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
			}
		}
		
		
		scanner=new Scanner(System.in);
		System.out.println("Please Enter From to station as given in list ");
		String station=scanner.nextLine();
		System.out.println("				Train between station");
		
		if(type.equalsIgnoreCase("p")){
			iteratorPtrain = ((ArrayList<Train>) ptrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Seats");
			while (iteratorPtrain.hasNext()) {
				Train tobject = iteratorPtrain.next();
				
				if(tobject.fromToStation.equalsIgnoreCase(station)){
					System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
				}
			}
			System.out.println("Please Enter the train number to book ticket");
			train_Number=scanner.nextLine();
			System.out.println("Please Enter the number of tickets");
			n_Ticket=scanner.nextInt();
		}
		else {
			iteratorGtrain = ((ArrayList<Train>) gtrain).iterator();
			System.out.println("Train Number   Travel-Time		Fare		From to Station		Available Weight");
			while (iteratorGtrain.hasNext()) {
				Train tobject = iteratorGtrain.next();
				if(tobject.fromToStation.equalsIgnoreCase(station)){
					System.out.println(tobject.trainNumber+"		"+tobject.timeDuration+"			"+tobject.fare+"			"+tobject.fromToStation+"			"+tobject.seats_weight);
				}
			}
			System.out.println("Please Enter the train number to send goods");
			train_Number=scanner.nextLine();
			System.out.println("Please Enter the number tonnes weight");
			n_Weight=scanner.nextInt();
		}
		
		int totalAmount=this.checkTicket(type, station,train_Number,n_Ticket,n_Weight
				);
		
		if(!(totalAmount==0)){
			
			//For passenger train
			if(type.equalsIgnoreCase("p")){
				scanner=new Scanner(System.in);
				String ticketId=train_Number+"_"+(++count);
				System.out.println("Enter the mode of payment(Credit card or wallet or e-banking)");
				String pmode = scanner.nextLine();
				String paymentId="";
				if(pmode.equalsIgnoreCase("credit card")){
					paymentId=ticketId+"_"+"CC"+count;
					System.out.println("Enter the card number");
					String cNumber=scanner.nextLine();
					System.out.println("Enter the cvv number");
					String cvvNumber=scanner.nextLine();
					pay=new CreditCard(paymentId,pmode,cNumber,cvvNumber);
					payment.add(pay);
				}
				else if(pmode.equalsIgnoreCase("wallet")){
					paymentId=ticketId+"_"+"W"+count;
					pay=new Wallet(paymentId,pmode);
					payment.add(pay);
				}
				else{
					paymentId=ticketId+"_"+"NB"+count;
					System.out.println("Enter the bank name");
					String bank=scanner.nextLine();
					System.out.println("Enter the user name");
					String uname=scanner.nextLine();
					System.out.println("Enter the password");
					String pwd=scanner.nextLine();
					pay=new NetBanking(paymentId,pmode,bank,uname,pwd);
					payment.add(pay);
				}
				System.out.println("Your ticket booked succesfully and your ticket id = "+ticketId);
				System.out.println();	
				passe=new Passenger(name,train_Number,ticketId,paymentId,n_Ticket,totalAmount);
				passenger.add(passe);
			}
			//for goods train
			else{		
				scanner=new Scanner(System.in);
				String ticketId=train_Number+"_"+(++count);
				System.out.println("Enter the mode of payment(Credit card or wallet or e-banking)");
				String pmode = scanner.nextLine();
				String paymentId="";
				if(pmode.equalsIgnoreCase("credit card")){
					paymentId=ticketId+"_"+"CC"+count;
					System.out.println("Enter the card number");
					String cNumber=scanner.nextLine();
					System.out.println("Enter the cvv number");
					String cvvNumber=scanner.nextLine();
					pay=new CreditCard(paymentId,pmode,cNumber,cvvNumber);
					payment.add(pay);
				}
				else if(pmode.equalsIgnoreCase("wallet")){
					paymentId=ticketId+"_"+"W"+count;
					pay=new Wallet(paymentId,pmode);
					payment.add(pay);
				}
				else{
					paymentId=ticketId+"_"+"NB"+count;
					System.out.println("Enter the bank name");
					String bank=scanner.nextLine();
					System.out.println("Enter the user name");
					String uname=scanner.nextLine();
					System.out.println("Enter the password");
					String pwd=scanner.nextLine();
					pay=new NetBanking(paymentId,pmode,bank,uname,pwd);
					payment.add(pay);
				}
				System.out.println("Your ticket booked succesfully and your ticket id = "+ticketId);
				System.out.println();
				good=new Goods(name,train_Number,ticketId,paymentId,n_Weight,totalAmount);
				goods.add(good);
			}
		}
		else{
			System.out.println("Train doesn't have enough space");
		}
		//scanner.close();
	}
		
	//this method check train have enough space or not and calculate amount to be paid
	int checkTicket(String type,String station,String train_Number,int n_Ticket,int n_Weight){
		int totalAmount=0;
		try{  
			if(type.equalsIgnoreCase("p")){
				iteratorPtrain = ((ArrayList<Train>) ptrain).iterator();
				while (iteratorPtrain.hasNext()) {
					Train tobject = iteratorPtrain.next();
					if(tobject.fromToStation.equalsIgnoreCase(station)&&tobject.trainNumber.equalsIgnoreCase(train_Number)&&tobject.seats_weight>=n_Ticket){
							tobject.seats_weight-=n_Ticket;		//update the number of seats
							totalAmount=tobject.fare*n_Ticket;	//calculate the total amount 
							return totalAmount;
					}
				}
			}
			else{
				iteratorGtrain = ((ArrayList<Train>) gtrain).iterator();
				while (iteratorGtrain.hasNext()) {
					Train tobject = iteratorGtrain.next();
					if(tobject.fromToStation.equalsIgnoreCase(station)&&tobject.trainNumber.equalsIgnoreCase(train_Number)&&tobject.seats_weight>=n_Weight){
							tobject.seats_weight-=n_Weight;		//update the number of seats
							totalAmount=tobject.fare*n_Weight;	//calculate total amount
							return totalAmount;
					}
				}
			}
			}catch(Exception e){
					e.printStackTrace();
				}
				return totalAmount;
	}
	
	//this method show the passenger and goods booking history
	void showTicketDetail(String type){
		if(type.equalsIgnoreCase("p")){
			iteratorPassenger = ((ArrayList<Passenger>) passenger).iterator();
			System.out.println("Passenger Name   Ticket ID		Payment ID		Train Id		Booked Seats		Paid Amount");
			while (iteratorPassenger.hasNext()) {
				Passenger tobject = iteratorPassenger.next();
				System.out.println(tobject.userName+"		  "+tobject.ticketId+" 		  "+tobject.paymentId+"  		"+tobject.trainNumber+"  		        "+tobject.nSeat+"		      "+tobject.totalAmount);
			}
		}
		else {
			iteratorGoods = ((ArrayList<Goods>) goods).iterator();
			System.out.println("Name	   Ticket ID		Payment ID		Train Id		Booked Weight		Paid Amount");
			while (iteratorGoods.hasNext()) {
				Goods tobject = iteratorGoods.next();
				System.out.println(tobject.userName+"	   "+tobject.ticketId+"		  "+tobject.paymentId+"		    "+tobject.trainNumber+"		 	   "+tobject.nWeight+"	 	 	"+tobject.totalAmount);
			}

		}
	}
	
	public static void main(String args[]) throws IOException{
	Scanner sc = new Scanner(System.in);
	TrainResevatationSystem trs=new TrainResevatationSystem();
	String userName="";
	String trainType="";
	int choice=0;
	trs.getTrainChart();
	do{
		
		System.out.println("Enter 1 to book ticket"); 
		System.out.println("Enter 2 to send goods");
		System.out.println("Enter 3 to show passenger train chart");
		System.out.println("Enter 4 to show goods train chart");
		System.out.println("Enter 5 to show passenger chart");
		System.out.println("Enter 6 to show Goods chart");
		System.out.println("Enter 7 to exit");
		choice=sc.nextInt();
		switch(choice){
		
			case 1:System.out.println("Enter User name");
				sc = new Scanner(System.in);
				userName=sc.nextLine();
				trainType="P";
				trs.allocateTicket(userName, trainType);
				break;
				
			
			case 2:System.out.println("Enter User name");
				sc = new Scanner(System.in);
				userName=sc.nextLine();
				trainType="G";
				trs.allocateTicket(userName, trainType);
				break;
			
			case 3:System.out.println("				Passenger train chart");
				trainType="P";
				trs.showTrainChart(trainType);
				break;

			case 4:System.out.println("				Goods train chart");
				trainType="G";
				trs.showTrainChart(trainType);
				break;
		
			case 5:System.out.println("						passenger chart");
				trainType="P";
				trs.showTicketDetail(trainType);
				break;
		
			case 6:System.out.println("							Goods chart");
				trainType="G";
				trs.showTicketDetail(trainType);
				break;
				
			case 7: return;
				
				
			default: System.out.println("Please enter right input");
		}
		
	}while(choice!=9);
	
	sc.close();
	}

}
