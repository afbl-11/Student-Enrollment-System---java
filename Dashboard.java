


public class Dashboard {
    
    public void profile(String StudentName, String StudentId, String Course) {

        System.out.println("Student's Profile");
        System.out.println("Name: " + StudentName);
        System.out.println("Student I.D: " + StudentId);
        System.out.println("Course: " + Course);
    }

    public void StudentDashboard(int operation) {
        switch (operation) {
            case 1:
                profile(null, null, null);
                break;
    
        
            default:
            System.out.println("Invalid Input!");
                break;
        }
        
        
    }
    
}
