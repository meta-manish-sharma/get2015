package InfixToPostfix;
/**
 * this class used to convert infix operator to postfix
 * @author Manish
 * 
 */
import java.util.Scanner;

//this method return the priority of operator
public class InfixToPostfix {
	static Stack stack=new Stack();
	
	static int  getPriority(char ch ) {
		if( ch == '+' || ch == '-' ) {
			return 0;
		}
		else if(ch == '*' || ch == '/') {
				return 1;	
				}
		else if (ch == '^' || ch == '%'){
			return 2;
		}
		else {
			return 3;
		}
		
	}
	
	
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix expression");
		String infix = sc.nextLine();
		String postfix="";
		int i=0;
		int priority = 0;
		char ch;
		while(i!=infix.length()) {
			ch=infix.charAt(i);
			if((ch >= 65 && ch <= 90) || (ch >= 65 && ch <= 122) ) {
				postfix += ch;
			}
			else {		
					if(stack.isEmpty()){
						priority=getPriority(ch);
						stack.push(ch);
					}
					else {
							if(getPriority(ch)>=priority){
								stack.push(ch);
								priority=getPriority(ch);
								
							}
							else{
								while(!(stack.isEmpty())){
									postfix+=stack.pop();
								}
								priority=0;
							}
					}		
			}
			i++;
		}
		while(!(stack.isEmpty())){
			postfix+=stack.pop();
		}	
			System.out.println(" postfix expression = "+postfix);
	}
}
