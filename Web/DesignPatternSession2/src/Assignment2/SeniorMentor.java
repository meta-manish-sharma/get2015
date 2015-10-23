/**
 * 
 */
package Assignment2;

/**
 * @author Manish
 *
 */
public class SeniorMentor extends LeaveHandler {
	public SeniorMentor(int day) {
		this.day = day;
	}

	@Override
	protected void leaveApprovalMessage() {
		System.out.println("Leave approved by senior mentor");
	}

}
