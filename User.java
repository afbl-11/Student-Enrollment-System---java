import java.io.*;
import java.util.*;

// Abstract User class
public abstract class User {

  private String firstName;
  private String middleInitial;
  private String lastName;
  private String password;
  private String studentId;

  public User(
    String firstName,
    String middleInitial,
    String lastName,
    String password,
    String studentId
  ) {
    this.firstName = firstName;
    this.middleInitial = middleInitial;
    this.lastName = lastName;
    this.password = password;
    this.studentId = studentId;
  }

  public String getStudentId() {
      return studentId;
  }

  public void setStudentId(String studentId) {
      this.studentId = studentId;
  }

  // this would give students their id.
  public String getFirstName() {
      return firstName;
  }
  
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public String getMiddleInitial() {
      return middleInitial;
  }

  public void setMiddleInitial(String middleInitial) {
      this.middleInitial = middleInitial;
  }
  
  public String getLastName() {
      return lastName;
  }
   public void setLastName(String lastName) {
       this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }
  
  public abstract String getUserType();
}
