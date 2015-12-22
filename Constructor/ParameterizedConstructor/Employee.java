package ParameterizedConstructor;

/**
 * @author Manish
 * Employee class having parameterized constructors.
 */
public class Employee {

	private String name;
	private int employeeId;
	private String address;
	private String department;
	
	/**
	 * Constructor with two arguments name and employeeId
	 * @param name
	 * @param employeeId
	 */
	public Employee(String name, int employeeId) {
		super();
		this.name = name;
		this.employeeId = employeeId;
	}

	/**
	 * Constructor with three arguments name, employeeId and address
	 * @param name
	 * @param employeeId
	 * @param address
	 */
	public Employee(String name, int employeeId, String address) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.address = address;
	}

	/**
	 * Constructor with three arguments name, employeeId, address and department
	 * @param name
	 * @param employeeId
	 * @param address
	 * @param department
	 */
	public Employee(String name, int employeeId, String address,
			String department) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.address = address;
		this.department = department;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Employee [name=" + name + ", employeeId=" + employeeId
				+ ", address=" + address + ", department=" + department + "]";
	}
	
}
