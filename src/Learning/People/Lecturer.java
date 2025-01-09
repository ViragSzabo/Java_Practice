package Learning.People;

import Learning.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Person
{
    private int salary;
    private final List<Course> coursesToTeach;

    /** Constructor */
    public Lecturer(String firstName, String lastName, LocalDate birthdate,
                    String gender, String email, String phone, int salary)
    {
        super(firstName, lastName, birthdate, gender, email, phone);
        this.salary = salary;
        coursesToTeach = new ArrayList<>();
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public List<Course> getCoursesToTeach()
    {
        return coursesToTeach;
    }

    public void addCourse(Course course)
    {
        coursesToTeach.add(course);
    }
}