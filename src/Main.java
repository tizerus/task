import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		StudentGroup group = new StudentGroup(1);
		Date ourDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(ourDate); // your date (java.util.Date)
		//cal.add(Calendar.MONTH, -20);
		cal.set(1987, 8, 10);
		ourDate = cal.getTime();
		Student stud1 = new Student(1, "student1", ourDate, 3.5 ); // 20 февраля 2000 года
		cal.set(1987, 5, 21);
		ourDate = cal.getTime();
		Student stud2 = new Student(2, "student2", ourDate, 20.9 ); // 21 апереля 1987 года
		cal.set(2000, 1, 18);
		ourDate = cal.getTime();
		Student stud3 = new Student(3, "student3", ourDate, 20.8 ); // 18 февраля 2000 года
		cal.set(2002, 8, 9);
		ourDate = cal.getTime();
		Student stud4 = new Student(4, "student4", ourDate, 20.9 ); // 24 июня 2002 года
		cal.set(2001, 8, 19);
		ourDate = cal.getTime();
		Student stud5 = new Student(5, "student5", ourDate, 19.9 ); // 19 июня 2001 года
		group.setStudent(stud1, 0);
		//group.setStudent(stud2, 1);
		//group.setStudent(stud3, 2);
		//group.setStudent(stud4, 3);
		//group.setStudent(stud5, 4);
		System.out.println(group.getStudents());
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}
		System.out.println("==================");
		group.addFirst(stud2);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}
		System.out.println("==================");
		group.addLast(stud3);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}
		System.out.println("========add=======");
		group.add(stud4, 2);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}
		/*System.out.println("========remove 2=======");
		group.remove(2);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}
		System.out.println("========remove student 3=======");
		group.remove(stud3);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		/*System.out.println("========removeToElement=======");
		group.removeToElement(stud3);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		/*System.out.println("========removeToindex=======");
		group.removeToIndex(3);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		/*System.out.println("========removeFromElement=======");
		group.removeFromElement(stud1);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		/*System.out.println("========removeFromIndex=======");
		group.removeFromIndex(1);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		/*System.out.println("========students by age=======");
		group.getStudentsByAge(0);
		for(int i = 0; i < group.getStudents().length; i++) {
			System.out.println(group.getStudent(i).getFullName());
		}*/
		Date datePlusDays = new Date();
		Calendar c = Calendar.getInstance(); 
		c.set(1987,5,22); 
		
	//	c.add(Calendar.DATE, days);
		datePlusDays = c.getTime();
		Date datePlusDays1 = new Date();
		Calendar c1 = Calendar.getInstance(); 
		c.set(1987,8,9); 
		
	//	c.add(Calendar.DATE, days);
		datePlusDays1 = c.getTime();
		
		group.getBetweenBirthDates(datePlusDays, datePlusDays1);
	}
}
