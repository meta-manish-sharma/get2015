/**
 * Payment is an abstract class and credit card
 * wallet and net banking classes extends this abstract class
 * and those classes store the payment information.
 * @author Manish 
 */
package Train_Reservation_System;

/*
 * this class payment have payment id and payment type attributes 
 */
public abstract class Payment {
	String paymentId="";
	String paymentType="";

}

/*
 * this class extends payment and store attributes for credit card information 
 */
class CreditCard extends Payment{
	String cardNumber;
	String cvvNumber;
	public CreditCard(String pId,String pt,String ccNumber,String cvv){
		this.paymentId=pId;
		this.paymentType=pt;
		this.cardNumber=ccNumber;
		this.cvvNumber=cvv;
	}
}

/*
 * this class extends payment and store attributes for wallet information 
 */
class Wallet extends Payment{
	
	public Wallet(String pId,String pt){
		this.paymentId=pId;
		this.paymentType=pt;
		
	}
}

/*
 * this class extends payment and store attributes for Net banking information 
 */
class NetBanking extends Payment{
	String userName;
	String bank;
	String password;
	public NetBanking(String pId,String pt,String bank,String uName,String pwd){
		this.paymentId=pId;
		this.paymentType=pt;
		this.bank=bank;
		this.userName=uName;
		this.password=pwd;
	}
}