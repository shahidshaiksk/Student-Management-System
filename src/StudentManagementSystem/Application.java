package StudentManagementSystem;
import java.util.*;
public class Application {
	public static void main(String[] args) {
		Activities activities = new Activities();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n------------------MENU:------------------");
			System.out.println("\n1.Create Course\n2.Delete Course\n3.Show Courses\n4.Create Student\n5.Show Students\n6.Find Student\n7.Modify Student\n8.Delete Student\n9.Exit");
			System.out.print("\nSelect your choice: ");
			switch(sc.nextInt()) {
			case 1:	{
				activities.createCourse();
				break;
				}
			case 2: {
				if(activities.getCourseDataSize()==0) {
					System.out.println("\nNo Course Data");
					break;
				}
				System.out.print("\nEnter course Id: ");
				activities.deleteCourse(sc.nextInt());
				break;
				}
			case 3: {
				if(activities.getCourseDataSize()==0) {
					System.out.println("\nNo Course Data");
					break;
				}
				activities.showCourses();
				break;
				}
			case 4: {
				activities.createStudent();
				break;
				}
			case 5: {
				if(activities.getStudentDataSize()==0) {
					System.out.println("\nNo Student Data");
					break;
				}
				activities.showStudents();
				break;
				}
			case 6: {
				if(activities.getStudentDataSize()==0) {
					System.out.println("\nNo Student Data");
					break;
				}
				System.out.print("\nEnter student Id: ");
				activities.showSpecificStudent(sc.nextInt());
				break;
				}
			case 7: {
				if(activities.getStudentDataSize()==0) {
					System.out.println("\nNo Student Data");
					break;
				}
				System.out.print("\nEnter student Id: ");
				activities.modifyStudent(sc.nextInt());
				break;
				}
			case 8: {
				if(activities.getStudentDataSize()==0) {
					System.out.println("\nNo Student Data");
					break;
				}
				System.out.print("\nEnter student Id: ");
				activities.deleteStudent(sc.nextInt());
				break;
				}
			case 9: {
				System.out.println("\nExiting...");
				return;
				}
			}
		}while(true);
	}
}
