package Learning;

import Learning.Exceptions.MaxNumberOfStudents;
import Learning.Exceptions.StudentNotFound;
import Learning.People.Lecturer;
import Learning.People.Person;
import Learning.People.Student;

import java.util.ArrayList;
import java.util.List;

public class Course
{
    private String title;
    private Person lecturer;
    private final List<Student> studentList;
    public final double GENERAL_PRICE = 250;

    public Course(String title, Person lecturer)
    {
        this.title = title;
        this.lecturer = lecturer;
        studentList = new ArrayList<Student>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Person getLecturer()
    {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public void addStudent(Student student) throws MaxNumberOfStudents
    {
        int MAX_CAPACITY = 2;
        if(studentList.size() >= MAX_CAPACITY)
        {
            throw new MaxNumberOfStudents("Maximum number of students reached");
        } else
        {
            studentList.add(student);
        }
    }

    public void removeStudent(Student student) throws StudentNotFound
    {
        if(!studentList.contains(student))
        {
            throw new StudentNotFound("Student not found");
        } else
        {
            studentList.remove(student);
        }
    }

    public double getPrice() {
        return GENERAL_PRICE;
    }
}