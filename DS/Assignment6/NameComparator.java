import java.util.Comparator;
/**
 * class override the compare method of comparator interface
 * and sort according employee name
 * @author Manish
 *
 */

public class NameComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee emp1 = (Employee) arg0;
		Employee emp2 = (Employee) arg1;
		return emp1.getName().compareTo(emp2.getName());
	}

	
		
}
