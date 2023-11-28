import java.io.*;
import java.util.*;

public class UserService {

  private final String userDB = "users.txt"; // Ensure this path is correct!

  // Register a user
  public void register(
    String firstName,
    String middleInitial,
    String lastName,
    String password,
    String Id,
    String userType,
    double averageGrade,
    String section,
    List<String> courses
  ) throws IOException {
    // ... [previous validation code remains unchanged]

    User user;
    if (userType.equalsIgnoreCase("Student")) {
      Student student = new Student(firstName,middleInitial,lastName,Id, password);
    //   courses.forEach(student::enrollCourse);
      user = student;
    } else { // Teacher
      user = new Teacher(firstName, middleInitial, lastName, Id, password,section);
    }

    saveUserToFile(user);
  }

  // Login a user
  public User login(String Id, String password) throws IOException {
    File file = new File(userDB);
    if (!file.exists()) {
        throw new FileNotFoundException("User database file not found.");
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userData = line.split(",");
            
            // Check if the array has enough elements to avoid ArrayIndexOutOfBoundsException
            if (userData.length >= 5 && userData[4].equals(Id) && userData[3].equals(password)) {
                String firstName = userData[0];
                String middleInitial = userData[1];
                String lastName = userData[2];

                if (userData[5].equalsIgnoreCase("Student")) {

                    List<String> courses = Arrays.asList(userData).subList(7, userData.length);
                    Student student = new Student(firstName, middleInitial, lastName, Id, password);
                    for (String course : courses) {
                        student.enrollCourse(course);
                    }
                    /* i think this line of code lets you select the course or show you the course */
                    return student; // this one is for Student student i think?
                } else if (userData[5].equalsIgnoreCase("Teacher")) {
                    Teacher teacher = new Teacher(firstName, middleInitial, lastName, Id, password, userData[6]);
                    return teacher;
                }
            }
        }
    }
    throw new IllegalArgumentException("Invalid username or password");
}
/* this whole function just checks if the input exist in our data files. it doesnt output anything
 * or read anything else. it is just a verification method.
 */

  // Save a user to the file
  private void saveUserToFile(User user) throws IOException {
    File file = new File(userDB);
    if (!file.exists()) {
      boolean isCreated = file.createNewFile();
      if (!isCreated) {
        throw new IOException("Failed to create user database file.");
      }
    }

    try (
      BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))
    ) {
      String userInfo =
        user.getFirstName() +
        "," +
        user.getMiddleInitial() +
                      "," +
        user.getLastName() +
                      "," +
        user.getStudentId() +
        "," +
        user.getPassword() +
        "," +
        user.getUserType();
      if (user instanceof Student) {
        Student student = (Student) user;
        userInfo += "," + student.doesQualify();
        String courses = String.join(";", student.getEnrolledCourses());
        if (!courses.isEmpty()) {
          userInfo += "," + courses;
        }
      } else if (user instanceof Teacher) {
        userInfo += "," + ((Teacher) user).getCredentials();
      }
      writer.write(userInfo);
      writer.newLine();
    }
  }

  // Check if a user exists this is for the login and register
  private boolean userExists(String username) throws IOException {
    File file = new File(userDB);
    if (!file.exists()) {
      return false;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] userData = line.split(",");
        if (userData[0].equals(username)) {
          return true;
        }
      }
    }
    return false;
  }
}
