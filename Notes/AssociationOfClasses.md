    EnrollmentSystem - User (Association):
        Multiplicity: * (Many Users can be associated with one EnrollmentSystem, and vice versa)
        Description: The EnrollmentSystem class has a list of users, including both students and teachers.

    User - Student (Inheritance):
        Relationship: Inheritance (Student is a specialized type of User)
        Description: The Student class inherits from the User class, representing an "is-a" relationship.

    User - Teacher (Inheritance):
        Relationship: Inheritance (Teacher is a specialized type of User)
        Description: The Teacher class inherits from the User class, representing an "is-a" relationship.

    EnrollmentSystem - Course (Association):
        Multiplicity: * (Many Courses can be associated with one EnrollmentSystem, and vice versa)
        Description: The EnrollmentSystem class has a list of courses, which students can enroll in.

    Course - Student (Association):
        Multiplicity: * (Many Students can be associated with one Course, but a Student can be associated with multiple Courses)
        Description: Each course can have multiple students enrolled.


        Certainly! Here is the list of classes created in the provided Java code:
