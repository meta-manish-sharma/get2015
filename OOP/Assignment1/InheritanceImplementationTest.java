/**
 * this junit test class for InheritanceImplementation 
 * @author Manish
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InheritanceImplementationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	Person person=new Person("Manish",111);	//Creating object of class Person
	Student student=new Student("Manish",111,123);	//Creating object of class Student
	Teacher teacher=new Teacher("Mohan",777,874,"Java");	//Creating object of class Teacher
	
	//Test toString method for Person class 
		@Test
		public void testTOPerson() {
			String expected="Manish	  111";
			assertEquals(expected,person.toString());
		}
	
	//Test toString method for Student class 
	@Test
	public void testTOStudent() {
		String expected="Manish	  111	  		123";
		assertEquals(expected,student.toString());
	}
	
	//Test setCourse and getCourse method for Student class 
		@Test
		public void testTOStudentCourse() {
			String course[] ={"CA","B.Com"};
			student.setCourse(course);
			String expected[]={"CA","B.Com"};
			assertArrayEquals(expected,student.getCourse());
		}
	
	//Test toString method for Teacher class 
	@Test
	public void testTOTeacher() {
		String expected="Mohan	  777		  874		Java";
		assertEquals(expected,teacher.toString());
	}

}
