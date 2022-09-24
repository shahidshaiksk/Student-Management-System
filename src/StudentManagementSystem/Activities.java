package StudentManagementSystem;
import java.util.*;

public class Activities {
	private int studentCount = 0;
	private int courseCount = 0;
	Scanner sc = new Scanner(System.in);
	Date date = new Date();
	private HashMap<Integer,Student> studentData = new HashMap<>();
	private HashMap<Integer,Course> courseData = new HashMap<>();
	public int getStudentDataSize(){
		return studentData.size();
	}
	public int getCourseDataSize() {
		return courseData.size();
	}
	public void createStudent() {
		Student student = new Student();
		System.out.print("\nEnter student name: ");
		student.setName(sc.nextLine());
		student.setRollNo(++studentCount);
		if(courseData.size()==0) {
			System.out.println("\nNo Course Data");
			return;
		}
		ArrayList<Course> courseList = new ArrayList<>();
		System.out.println("\nCourse List:");
		showCourses();
		System.out.print("\nEnter number of courses: ");
		for(int i=sc.nextInt();i>0;i--) {
			System.out.print("\nEnter course ID: ");
			int key=sc.nextInt();
			if(courseData.containsKey(key)) {
				courseList.add(courseData.get(key));
			}
			else {
				i++;
				System.out.println("Course doesn't exist");
			}
		}
		student.setCourseList(courseList);
		student.setYoj(date.getYear());
		studentData.put(student.getRollNo(), student);
	}
	public boolean findStudent(int studentId) {
		return studentData.containsKey(studentId);
	}
	public void showSpecificStudent(int studentId) {
		if(findStudent(studentId)) {
			System.out.println("\nStudent Roll No\tStudent Name\tStudent CourseList\tStudent Year Of Joining");
			Student student = studentData.get(studentId);
			System.out.print(student.getRollNo()+"\t"+student.getName()+"\t");
			for(Course course:student.getCourseList()) {
				System.out.print(course.getCourseName()+" ");
			}
			System.out.println("\t"+student.getYoj());
		}
		else {
			System.out.println("\nNo student found");
		}
	}
	public void showStudents() {
		System.out.println("\nStudent Roll No\tStudent Name\tStudent CourseList\tStudent Year Of Joining");
		for(Map.Entry<Integer,Student> entry: studentData.entrySet()) {
			Student student = entry.getValue();
			System.out.print(student.getRollNo()+"\t"+student.getName()+"\t");
			for(Course course:student.getCourseList()) {
				System.out.print(course.getCourseName()+" ");
			}
			System.out.println("\t"+student.getYoj());
		}
	}
	public void modifyStudent(int studentId) {
		if(findStudent(studentId)) {
			Student student = studentData.get(studentId);
			ArrayList<Course> courseList = new ArrayList<>();
			System.out.println("\nCourse List:");
			showCourses();
			if(courseData.size()==0) {
				System.out.println("\nNo Course Data");
				return;
			}
			System.out.print("\nEnter number of courses: ");
			for(int i=sc.nextInt();i>0;i--) {
				System.out.print("\nEnter course ID: ");
				int key=sc.nextInt();
				if(courseData.containsKey(key)) {
					courseList.add(courseData.get(key));
				}
				else {
					i++;
					System.out.println("\nCourse doesn't exist");
				}
			}
			student.setCourseList(courseList);
			student.setYoj(date.getYear());
			studentData.put(student.getRollNo(), student);
		}
		else {
			System.out.println("\nNo student found");
		}
	}
	public void deleteStudent(int studentId) {
		if(findStudent(studentId)) {
			studentData.remove(studentId);
		}
		else {
			System.out.println("\nNo student found");
		}
	}
	public void showCourses() {
		System.out.println("\nCourse ID\tCourse Name");
		for(Map.Entry<Integer,Course> entry:courseData.entrySet()) {
			Course course = entry.getValue();
			System.out.println(course.getCourseId()+"\t"+course.getCourseName());
		}
	}
	public void createCourse() {
		Course course = new Course();
		System.out.print("\nEnter course name: ");
		course.setCourseName(sc.nextLine());
		course.setCourseId(++courseCount);
		courseData.put(courseCount, course);
	}
	public void deleteCourse(int courseId) {
		if(findCourse(courseId)) {
			courseData.remove(courseId);
		}
		else {
			System.out.println("\nCourse doesn't exist");
		}
	}
	public boolean findCourse(int courseId) {
		return courseData.containsKey(courseId);
	}
}
