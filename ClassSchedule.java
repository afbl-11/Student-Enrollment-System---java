public class ClassSchedule {
    private String course;
    private String year;
    private String section;
    private String dateAndTime;
    private String subject;
    private int price; // Assuming the price is in PHP

    // Constructor
    public ClassSchedule(String course, String year, String section, String dateAndTime, String subject, int price) {
        this.course = course;
        this.year = year;
        this.section = section;
        this.dateAndTime = dateAndTime;
        this.subject = subject;
        this.price = price;
    }

    // Getter methods
    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getSubject() {
        return subject;
    }

    public int getPrice() {
        return price;
    }

    // toString method for easy printing
    // @Override
    // public String toString() {
    //     return String.format("Course: %s, Year: %d, Section: %s, Date and Time: %s, Subject: %s, Price: %d PHP",
    //             course, year, section, dateAndTime, subject, price);
    // }
}