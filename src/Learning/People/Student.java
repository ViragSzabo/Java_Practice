package Learning.People;

import Learning.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person
{
    private final List<Course> courses;

    /** Constructor */
    public Student(String firstName, String lastName, LocalDate birthdate, String gender, String email, String phone) {
        super(firstName, lastName, birthdate, gender, email, phone);
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public double getPay()
    {
        return calculatePayment();
    }

    private double calculatePayment()
    {
        return courses.stream().mapToDouble(Course::getPrice).sum();
    }

    public void apply(Course course)
    {
        addCourse(course);
    }
}