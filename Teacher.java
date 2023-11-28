public class Teacher extends User {
    private String credentials;

    public Teacher(String firstName,String middleInitial,String lastName,String employeeId, String password, String credentials) {
        super(firstName,middleInitial,lastName,employeeId, password);
        this.credentials = credentials;
    }

    @Override
    public String getUserType() {
        return "Teacher";
    }

    public String getCredentials() {
        return credentials;
    }
}
