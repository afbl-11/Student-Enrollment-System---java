import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class UserRegistration {
    
    static final double qualifyingGrade = 90.00;
    static double gradesInput[] = new double[8];
    double doesqualify;
    static boolean isValidPassword = false;
    static private String password;
    static String SHSsubjects[] = { "English", "Math", "Science", "P.e", "Recess", "Filipino","Ethics", "Statistics"};
    private static List<String> courses;
   

    public static double validateGrade() {
        double sum = 0.0;
        for (double grade : gradesInput) {
            sum += grade;
        }
        return sum / gradesInput.length;
    }
    
    private static void handleRegistration() {
    
        UserService userService = new UserService();
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().toUpperCase();
        System.out.print("Enter Middle initial: ");
        String middleInitial = scanner.nextLine().toUpperCase();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().toUpperCase();
        
        do {
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            try {
                Validators.validatePassword(password);
                isValidPassword = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid password! " + e.getMessage());
            }
        } while (!isValidPassword);

        System.out.print("Enter user type (Student/Teacher): ");
        String userType = scanner.nextLine().toUpperCase();
        String studentId = generateIdNumber();

        try {
            // identify if student
            if (userType.equalsIgnoreCase("STUDENT")) {
                System.out.println("Enter your grade in Senior High School. ");
                for (int i = 0; i < 8; i++) {
                    System.out.print(SHSsubjects[i] + ": ");
                    gradesInput[i] = scanner.nextDouble();
                }
                scanner.nextLine();  
                double doesqualify = validateGrade();

                if (doesqualify >= qualifyingGrade) {
                    System.out.println("Select course, year, adn section: ");
                    String selectCourse = scanner.nextLine();
                    String selectYear = scanner.nextLine();
                    String selectSection = scanner.nextLine();
                    courses = CourseService.courseSelection(selectCourse, selectYear, selectSection); // Handle course selection
                    
                    userService.register(firstName,middleInitial,lastName,studentId, password, userType, doesqualify, null, courses); //would register user, bring fields to function in user service
                } 
                 else {
                    System.out.println("Sorry but you don't meet the school standards.");
                    // System.exit(0);
                    scanner.close();
                    return;
                }
            } else if (userType.equalsIgnoreCase("Teacher")) {

            String courses[] = { "IT", "Engineering", "Multi-Media Arts", "Architecture", "Computer Science" };
            /*  
            *These should be the courses that we will choose from the file
            * i think making the files would be useless if we are not going to use it in matching. 
            * 
            * ! but it means more work! 
            */

            System.out.println("On what course do you teach: ");
            System.out.println("List of Courses: ");
            for (int i = 0; i < courses.length; i++) {
                System.out.println(courses[i]);
            }
            String courseInstructed = scanner.nextLine();

            System.out.println("Select Year: ");
            String courseYear = scanner.nextLine();
            courseYear = courseYear.toUpperCase();
            System.out.println("Select Section: ");
            String courseSection = scanner.nextLine();
            courseSection = courseSection.toUpperCase();

            CourseService.courseSelection(courseInstructed, courseYear, courseSection);

            String employeeId = generateIdNumber();
            userService.register(firstName,middleInitial,lastName,employeeId, password, userType, 0, courseInstructed,null);
                //identifies if teacher
            } else {
                System.out.println("Invalid user type.");
            }
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
        scanner.close();
    }

    public void getRegistration() {
        handleRegistration();
    }

    public static String generateIdNumber() {
        LocalDate year = LocalDate.now();
        int currentYear = year.getYear();
        Random random = new Random();
        StringBuilder IdBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int idNumber = random.nextInt(10); // Random number between 1 and 100
            IdBuilder.append(idNumber);
        }

        String currentYearString = String.valueOf(currentYear);
        String idNumber = currentYearString + IdBuilder.toString();

        return idNumber;
    }

}

// we still need to capitalize the strings