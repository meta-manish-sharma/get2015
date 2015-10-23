/**
 * 
 */
package Assignment2;

/**
 * @author Manish
 *
 */
public class HRManager extends LeaveHandler {
	public HRManager(int day) {
		this.day = day;
	}

	@Override
	protected void leaveApprovalMessage() {
		System.out.println("Leave approved by HR manager");
	}

}
