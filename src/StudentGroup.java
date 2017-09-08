
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
		// Add your implementation here
		
	}

	@Override
	public void setStudents(Student[] students) {
		if(students == null) {
			throw new IllegalArgumentException();
		} else {
			this.students = students;
		}	
		// Add your implementation here
	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		} else {
			return students[index];
			}
		// Add your implementation here
		
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null || index < 0 || index >= students.length ) {
			throw new IllegalArgumentException();
		} else {
			students[index] = student;
		}
		// Add your implementation here
	}

	@Override
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length+1];
			students[0] = student;
			for(int i = 0; i < temp.length; i++){
				students[i+1] = temp[i];
			}
			
		}
		// Add your implementation here
	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length+1];
			
			for(int i = 0; i < temp.length; i++){
				students[i] = temp[i];
			}
			students[students.length-1] = student;
			
		}
		// Add your implementation here
	}

	@Override
	public void add(Student student, int index) {
		int count = 0;
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length+1];
			for(int i = 0; i < temp.length; i++){
				if (i == index) {
					students[i] = student;
					count++;
				}
				students[i] = temp[i-count];
			}
		}
		// Add your implementation here
	}

	@Override
	public void remove(int index) {
		int count = 0;
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length-1];
			for(int i = 0; i < temp.length; i++) {
				if(i == index) {
					count++;
				}
				students[i] = temp[i+count];
			}
		}
		// Add your implementation here
	}

	@Override
	public void remove(Student student) {
		int count = 0;
		int indexDelete;
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < students.length; i ++) {
				if (students[i].equals(student)) {
					indexDelete = i;
					Student[] temp = new Student[students.length];
					for(int j = 0; j < temp.length; j++) {
						temp[j] = students[j];
					}
					students = new Student[students.length-1];
					for(int z = 0; z < students.length; i++) {
						if (z == indexDelete) {
							count ++;
						}
						students[z] = temp[z+count];
					}
					break;
				} else System.out.println("Student not exist");
			}	
		// Add your implementation here
	}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}

