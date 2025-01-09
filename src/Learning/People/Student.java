package Learning.People;

import Learning.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person
{
    private final List<Course> takenCourses;

    /** Constructor */
    public Student(String firstName, String lastName, LocalDate birthdate, String gender, String email, String phone) {
        super(firstName, lastName, birthdate, gender, email, phone);
        this.takenCourses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return takenCourses;
    }

    public void addCourse(Course course)
    {
        takenCourses.add(course);
    }

    public double getPay()
    {
        return calculatePayment();
    }

    private double calculatePayment()
    {
        return takenCourses.stream().mapToDouble(Course::getPrice).sum();
    }

    public void apply(Course course)
    {
        addCourse(course);
    }
}