/**
 * Survey System
 * @author Manish
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * Survey class which manage the whole Survey System 
 *
 */
public class Survey {
	
	//ArrayList that maintain the Participant objects
	public static ArrayList<Participant> participant = new ArrayList<Participant>();
	
	
	//method calculate the percentage rating 
	public double[]  getOverAllRating(){	
		double[] result=new double[5];
		double rating1=0,rating2=0,rating3=0,rating5=0,rating4=0;
		double counter=0;
		
		Iterator<Participant> iterator = ((ArrayList<Participant>) participant)
				.iterator();
		while (iterator.hasNext()) {
			Participant pobject = iterator.next();
			counter++;
			if (pobject.singleChoice.equalsIgnoreCase("1")){
				
				rating1++;
			}
			else if(pobject.singleChoice.equalsIgnoreCase("2")){
				rating2++;
			}
			else if(pobject.singleChoice.equalsIgnoreCase("3")){
				rating3++;
			}
			else if(pobject.singleChoice.equalsIgnoreCase("4")){
				rating4++;
			}
			else if(pobject.singleChoice.equalsIgnoreCase("5")){
				rating5++;
			}
		} 
		result[0]=(rating1/counter)*100;
		result[1]=(rating2/counter)*100;
		result[2]=(rating3/counter)*100;
		result[3]=(rating4/counter)*100;
		result[4]=(rating5/counter)*100;
		return result;
	}

	public static void main(String[] args) {
		
		SingleSelect sSelect=new SingleSelect("1"," Overall Rating, Single Select, (1/2/3/4/5)");
		MultiSelect mSelect=new MultiSelect("2","Area of improvement, Multi Select, (Service Quality/ Communication/ Delivery Process)");
		Text text=new Text("3","Feedback, Text");
		
		
		 int p=0;
		 String flag="0";
		 System.out.println("****Servey System****\n");
			while (flag.equals("0")) {
				
				int pId = (++p);
				Scanner sc=new Scanner(System.in);
				System.out.println("**Answer the Following Questions** \n");
				System.out.println(sSelect.qBody);
				
				String q1=sc.nextLine();
				if(!(q1.equals("1")||q1.equals("2")||q1.equals("3")||q1.equals("4")||q1.equals("5"))){
					System.out.println("Please enter number 1/2/3/4/5 only");
					q1=sc.nextLine();
				}
				System.out.println(mSelect.qBody);
				
				String q2=sc.nextLine();
				System.out.println(text.qBody);
				String q3=sc.nextLine();
				
				Participant part=new Participant(pId,q1,q2,q3);
				participant.add(part);
				
				System.out.println("\nIf you want to continue Application then Press 0 \nfor exit from Application Press Any key");
				
				if (!(sc.next().equals("0"))) {
					System.out.println("\nAre You Really Want to Exit From Application ? y/n");
					if (sc.next().equalsIgnoreCase("n")) {
						flag = "0";
					} else {
						flag = "1";
					}
				}
			}
			
			System.out.println(" \nPERCENTAGE COMPARISION OF RATING ");
			double []result=new Survey().getOverAllRating();
			for(int i=0;i<result.length;i++){
				System.out.println((i+1)+" - "+result[i]+"%");
			}
			System.out.println("\n REPORT OF PARTICIPANT ");
			int i=1;
			Iterator<Participant> iteratorParticipant = ((ArrayList<Participant>) participant)
					.iterator();
			while (iteratorParticipant.hasNext()) {
				Participant pobject = iteratorParticipant.next();
				System.out.println("\n\nParticipant "+i+"\n");
				System.out.println("Q."+sSelect.qId+"  "+sSelect.qBody);
				System.out.println("Answer = " +pobject.singleChoice);
				
				
				System.out.println(mSelect.qId+"  "+mSelect.qBody);
				System.out.println("Answer = " +pobject.multiChoice);
				
				System.out.println("Q."+text.qId+"  "+text.qBody);
				System.out.println("Answer = " +pobject.text);
				i++;
		}
		
		
	}
}



//this class contains Attributes of Participants
class Participant{
	int pId;
	String singleChoice;
	String multiChoice;
	String text;
	
	    public Participant(int pId,String q1,String q2,String q3){
		this.pId=pId;
		this.singleChoice=q1;
		this.multiChoice=q2;
		text=q3;
		
		}
	
	
	    
	
	
}

//Super class of every Question type

class Question{
	  
   public String qId;
	String qBody="";
	public Question(String qId,String qBody ){
		this.qBody=qBody;
		this.qId=qId;
	}
	
}

//class of Single Select Question

class SingleSelect extends Question{
	
	public SingleSelect(String qId,String qBody){
		super(qId,qBody);
	}
	
}

//class of Multi select Question
class MultiSelect extends Question{
	

	public MultiSelect(String qId,String qBody){
		super(qId,qBody);
	}
	
	
}

//class of Feedback
class Text extends Question{
	

	public Text(String qId,String qBody){
		super(qId,qBody);
	}
	
}
