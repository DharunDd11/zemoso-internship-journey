import java.util.*;
import java.util.stream.*;

public class StudentService {

    public static void printDepartmentNames(List<Student> list) {

        list.stream()
                .map(Student::getEngDepartment)
                .distinct()
                .forEach(System.out::println);
    }

    public static void studentsEnrolledAfter2018(List<Student> list) {

        list.stream()
                .filter(s -> s.getYearOfEnrollment() > 2018)
                .map(Student::getName)
                .forEach(System.out::println);
    }

    public static void maleCSStudents(List<Student> list) {

        list.stream()
                .filter(s -> s.getGender().equalsIgnoreCase("Male"))
                .filter(s -> s.getEngDepartment().equalsIgnoreCase("Computer Science"))
                .forEach(System.out::println);
    }

    public static void countByGender(List<Student> list) {

        System.out.println(
                list.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGender,
                                Collectors.counting()
                        ))
        );
    }

    public static void averageAgeByGender(List<Student> list) {

        System.out.println(
                list.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGender,
                                Collectors.averagingInt(Student::getAge)
                        ))
        );
    }

    public static void highestPercentageStudent(List<Student> list) {

        Student s =
                list.stream()
                        .max(Comparator.comparingDouble(
                                Student::getPerTillDate))
                        .get();

        System.out.println(s);
    }

    public static void countStudentsByDepartment(List<Student> list) {

        System.out.println(
                list.stream()
                        .collect(Collectors.groupingBy(
                                Student::getEngDepartment,
                                Collectors.counting()
                        ))
        );
    }

    public static void averagePercentByDepartment(List<Student> list) {

        System.out.println(
                list.stream()
                        .collect(Collectors.groupingBy(
                                Student::getEngDepartment,
                                Collectors.averagingDouble(
                                        Student::getPerTillDate
                                )
                        ))
        );
    }

    public static void youngestMaleElectronic(List<Student> list) {

        Student s =
                list.stream()
                        .filter(st -> st.getGender().equalsIgnoreCase("Male"))
                        .filter(st -> st.getEngDepartment().equalsIgnoreCase("Electronic"))
                        .min(Comparator.comparingInt(Student::getAge))
                        .get();

        System.out.println(s);
    }

    public static void csGenderCount(List<Student> list) {

        System.out.println(
                list.stream()
                        .filter(s -> s.getEngDepartment()
                                .equalsIgnoreCase("Computer Science"))
                        .collect(Collectors.groupingBy(
                                Student::getGender,
                                Collectors.counting()
                        ))
        );
    }
}