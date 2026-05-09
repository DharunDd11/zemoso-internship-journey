import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> students = StudentData.getStudents();

        System.out.println("1. Departments");
        StudentService.printDepartmentNames(students);

        System.out.println("\n2. Enrolled After 2018");
        StudentService.studentsEnrolledAfter2018(students);

        System.out.println("\n3. Male CS Students");
        StudentService.maleCSStudents(students);

        System.out.println("\n4. Count By Gender");
        StudentService.countByGender(students);

        System.out.println("\n5. Average Age By Gender");
        StudentService.averageAgeByGender(students);

        System.out.println("\n6. Highest Percentage Student");
        StudentService.highestPercentageStudent(students);

        System.out.println("\n7. Count By Department");
        StudentService.countStudentsByDepartment(students);

        System.out.println("\n8. Average Percentage By Department");
        StudentService.averagePercentByDepartment(students);

        System.out.println("\n9. Youngest Male Electronic Student");
        StudentService.youngestMaleElectronic(students);

        System.out.println("\n10. Computer Science Gender Count");
        StudentService.csGenderCount(students);
    }
}