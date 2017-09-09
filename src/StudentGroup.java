
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
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
	
	public static Boolean dateCompare(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		return sameDay;
	}
	public static Boolean dateCompareBetweenDates(Date date1, Date date2, Date studentBirthday) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		cal3.setTime(studentBirthday);
		boolean sameDay = (cal1.get(Calendar.YEAR) <= cal3.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) <= cal3.get(Calendar.DAY_OF_YEAR))
				&& (cal2.get(Calendar.YEAR) >= cal3.get(Calendar.YEAR) && cal2.get(Calendar.DAY_OF_YEAR) >= cal3.get(Calendar.DAY_OF_YEAR));
		return sameDay;
	}
	 public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
	        if ((birthDate != null) && (currentDate != null)) {
	            return Period.between(birthDate, currentDate).getYears();
	        } else {
	            return 0;
	        }
	    }
	
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
			for(int i = 0; i < students.length; i++){
				if (i == index) {
					students[i] = student;
					count++;
					i++;				
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
			for(int i = 0; i < students.length; i++) {
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
		int indexDelete;
		boolean isDeleted = false;
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < students.length; i ++) {
				if (students[i].equals(student)) {
					indexDelete = i;
					isDeleted = true;
					this.remove(indexDelete);
					break;
				} 
			} 
		// Add your implementation here
		}
		if (isDeleted == false) {
			System.out.println("Student not exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length-(students.length-1-index)];
			for (int i = 0; i < students.length; i ++) {
				students[i] = temp[i];
			}
		}
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		int indexDelete;
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < students.length; i ++) {
				if (students[i].equals(student)) {
					indexDelete = i;
					this.removeFromIndex(indexDelete);
				}
			}
		// Add your implementation here
		}
	}

	@Override
	public void removeToIndex(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] temp = new Student[students.length];
			for(int i = 0; i < temp.length; i ++) {
				temp[i] = students[i];
			}
			students = new Student[students.length-index];
			for (int i = 0; i < students.length; i ++) {
				students[i] = temp[i+index];
			}
		}
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		int indexDelete;
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < students.length; i ++) {
				if (students[i].equals(student)) {
					indexDelete = i;
					this.removeToIndex(indexDelete);
				}
			}
		// Add your implementation here
		}
	}

	@Override
	public void bubbleSort() {
		
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		Student[] studentsByDate;
		int index = 0;
		int count = 0;
		if (date == null) {
			throw new IllegalArgumentException();
		} else {
			for(int i = 0; i< students.length; i++){
				if((dateCompare(students[i].getBirthDate(), date) == true)){
					count++;
				}
			}
			if(count == 0) {
				return null;
			} else {
				studentsByDate = new Student[count];
				for (int i = 0; i < students.length; i++) {
					if(dateCompare(students[i].getBirthDate(), date) == true) {
						studentsByDate[index] = students[i];
						index++;
					}
				}
			}
		}
		// Add your implementation here
		return studentsByDate;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		int index = 0;
		int count = 0;
		Student[] studentArrBetweenBirthDates;
		if (firstDate == null || lastDate == null) {
			throw new IllegalArgumentException();
		} else {
			for(int i = 0; i < students.length; i++) {
				if(this.dateCompareBetweenDates(firstDate, lastDate, students[i].getBirthDate()) == true) {
					count++;
				}
			}
			if (count == 0) {
				return null;
			} else {
				studentArrBetweenBirthDates = new Student[count];
				for(int i = 0; i < students.length; i++) {
					if(this.dateCompareBetweenDates(firstDate, lastDate, students[i].getBirthDate()) == true) {
						studentArrBetweenBirthDates[index] = students[i];
						index++;
					}
				}
				return studentArrBetweenBirthDates;
			}
			// Add your implementation here
			
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		Student[] StudentsNerBirthsDate;
		int index = 0;
		int count = 0;
		if (date == null) {
			throw new IllegalArgumentException();
		} else {
			Date datePlusDays = new Date();
			Calendar c = Calendar.getInstance(); 
			c.setTime(datePlusDays); 
			c.add(Calendar.DATE, days);
			datePlusDays = c.getTime();
			for(int i = 0; i < students.length; i++) {
				if (this.dateCompareBetweenDates(date, datePlusDays, students[i].getBirthDate()) == true) {
					count++;
				}
 			}
			if(count == 0) {
				return null;
			} else {
				StudentsNerBirthsDate = new Student[count];
				for(int i = 0; i < students.length; i++) {
					if (this.dateCompareBetweenDates(date, datePlusDays, students[i].getBirthDate()) == true) {
						StudentsNerBirthsDate[index] = students[i];
						index++;
					}
	 			}
			}
			return StudentsNerBirthsDate;
		}
		
		// Add your implementation here
		
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		int age = 0;
		LocalDate currentDate = LocalDate.now();
		if (indexOfStudent == 0) {
			throw new IllegalArgumentException();
		} else {
			Date input = students[indexOfStudent-1].getBirthDate();
			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			age = this.calculateAge(date, currentDate);
		}
		// Add your implementation here
		return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		Student[] arrStudentsByAge;
		int index = 0;
		int count = 0;
		for(int i = 0; i < students.length; i++) {
			if(this.getCurrentAgeByDate(i+1) == age) {
				count++;// Add your implementation here
			}
		}
		if(count == 0){
			return null;
		} else {
			arrStudentsByAge = new Student[count];
			for(int i = 0; i < students.length; i++) {
				if(this.getCurrentAgeByDate(i+1) == age) {
					arrStudentsByAge[index] = students[i];
					index++;// Add your implementation here
				}
			}
			return arrStudentsByAge;
		}
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		int index = 0;
		Student[] studentsWithMaxAvgMark;
		int count = 0;
		double maxAvg = 0.0;
		for(int i = 0; i < students.length; i++){
			if(students[i].getAvgMark() > maxAvg) {
				maxAvg = students[i].getAvgMark();
			}
		}	
		for(int i = 0; i < students.length; i++){
			if(students[i].getAvgMark() == maxAvg) {
				count++;
			}
		}
		System.out.println(count);
		if(count == 0) {
			return null;
		} else {
			studentsWithMaxAvgMark = new Student[count];
			for(int i = 0; i < students.length; i++){
				if(students[i].getAvgMark() == maxAvg) {
					studentsWithMaxAvgMark[index] = students[i];
					index++;
				}
			}	
			return studentsWithMaxAvgMark;
		}	

	
		// Add your implementation here
		
	}

	@Override
	public Student getNextStudent(Student student) {
		Student nextStudent = null;
		if(student == null) {
			throw new IllegalArgumentException();
		} else {
			for(int i = 0; i < students.length; i++) {
				if(student.equals(students[i]) && (i+1) < students.length) {
					nextStudent =  students[i+1];
				} 
			} 
			return nextStudent;
		}
		
	}
}

