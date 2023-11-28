import java.io.*;
import java.util.*;

public class CourseService {
    private final static String userCourseSelect = "IT section and schedule(all level).txt";
    private final static String selectedCourseFile = "users.txt";

    private static final int COURSE_FEE = 10000; // Fixed fee per course

    public CourseService() {
    }

    public static List<String> courseSelection(String course, String year, String section) throws IOException {
        File ITcourseFiles = new File(userCourseSelect);
        if (!ITcourseFiles.exists()) {
            throw new FileNotFoundException("Course schedule file not found.");
        }

        List<String> selectedCourseInfo = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ITcourseFiles))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");

                if (userData.length >= 6 && userData[0].equals(course) && userData[1].equals(year) && userData[2].equals(section)) {
                    String Course = userData[0];
                    String Year = userData[1];
                    String Section = userData[2];

                    // Process the course selection and add information to the result
                    selectedCourseInfo.add(Course);
                    selectedCourseInfo.add(Year);
                    selectedCourseInfo.add(Section);

                    // Write the selected course information to the file
                    writeSelectedCourseToFile(selectedCourseInfo);
                    
                    return selectedCourseInfo;
                }
            }
        }

        throw new IllegalArgumentException("Invalid course, year, or section");
    }

  private static void writeSelectedCourseToFile(List<String> courseInfo) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedCourseFile, true))) {
        // Write each piece of course information on a new line, separated by commas
        String courseInfoLine = String.join(",", courseInfo.subList(0, courseInfo.size() - 1));
        writer.write(courseInfoLine + "," + courseInfo.get(courseInfo.size() - 1));
        writer.newLine();
    }
}

}
