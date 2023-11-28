import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseService {
    private final static String userCourseSelect = "IT section and schedule(all level).txt";
    
    private static final int COURSE_FEE = 10000; // Fixed fee per course
   

    public CourseService() {
    
    
    }
  

    /* 
     * This funtion is similar with the login function. it checks and access the data from the file
     * Course,Year,Section,Date and Time,Subject,Price (PHP)
     */

    public static List<String> courseSelection(String course, String year, String section) throws IOException {
    File ITcourseFiles = new File(userCourseSelect);
    if (!ITcourseFiles.exists()) {
        throw new FileNotFoundException("Course schedule file not found.");
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(ITcourseFiles))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userData = line.split(",");

            if (userData.length >= 6 && userData[0].equals(course) && userData[1].equals(year) && userData[2].equals(section)) {
                String Course = userData[0];
                String Year = userData[1];
                String Section = userData[2];

                // Process the course selection and return the result
                // (You may need to modify this part based on your requirements)
                List<String> result = new ArrayList<>();
                result.add(Course);
                result.add(Year);
                result.add(Section);
                return result;
            }
        }
    }

    throw new IllegalArgumentException("Invalid course, year, or section");
}


}

