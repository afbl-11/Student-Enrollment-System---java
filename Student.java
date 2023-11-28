import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private boolean gradesQualify;
    private List<String> enrolledCourses;
    private double averageGrade;

    public Student(String firstName,String middleInitial, String lastName, String password,String studentID) {
        super(firstName,middleInitial,lastName, studentID, password);
        this.enrolledCourses = new ArrayList<>();
        this.averageGrade = averageGrade;
        this.gradesQualify = averageGrade >= 80.0;
    }

    @Override
    public String getUserType() {
        return "Student";
    }

    public boolean doesQualify() {
        return gradesQualify;
    }

    public void enrollCourse(String courseCode) {
        enrolledCourses.add(courseCode);
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }
}
//