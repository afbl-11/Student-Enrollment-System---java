import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
    UserService userService = new UserService();
    CourseService courseService = new CourseService();
    userLogin Userlogin = new userLogin();
    UserRegistration userRegistration = new UserRegistration();

       do{
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userRegistration.getRegistration();
                    System.out.println("it works");
                    
                    break;
                case 2:
                    Userlogin.getLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (true);
    }
}



