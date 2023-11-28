import java.io.IOException;
import java.util.Scanner;

public class userLogin {

  private static void handleLogin() {
    UserService userService = new UserService();

    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter I.D number: ");
    String Id = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    try {
      User user = userService.login(Id, password);
      System.out.println("Login successful! Welcome, " + user.getFirstName() + " " + user.getMiddleInitial() +" " + user.getLastName());

      //enrolled courses should appear here
     
      if (user instanceof Teacher) {
        Teacher teacher = (Teacher) user;
        System.out.println("Credentials: " + teacher.getCredentials());
      } 
    } catch (IOException e) {
      System.out.println("Error during login: " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public void getLogin() {
    handleLogin();
  }
}
