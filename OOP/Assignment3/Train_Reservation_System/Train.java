/**
 * This file have two types of class one for passenger and another for goods train. 
 * @author Manish 
 */
package Train_Reservation_System;

/*
 * this class stores the information about train.
 */
public abstract class Train {
		
		public String tType="";
		public String trainNumber="";
		public String timeDuration="";
		public int fare=0;
		public String fromToStation="";
		public int seats_weight=0;
	

}

/*
 * this class stores the information about Passenger train.
 */
class Ptrain extends Train{
	
	public  Ptrain(String tt,String n,String t,int m,String fts,int s){
		this.tType=tt;
		this.trainNumber=n;
		this.timeDuration=t;
		this.fare=m;
		this.fromToStation=fts;
		this.seats_weight=s;
	}
}

/*
 * this class stores the information about Goods train.
 */
class Gtrain extends Train{
	
	public  Gtrain(String tt,String n,String t,int m,String fts,int w){
		this.tType=tt;
		this.trainNumber=n;
		this.timeDuration=t;
		this.fare=m;
		this.fromToStation=fts;
		this.seats_weight=w;
	}
}