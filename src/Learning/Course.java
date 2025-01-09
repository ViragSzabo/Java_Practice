package Learning;

import java.util.ArrayList;
import java.util.List;

public class Course
{
    private String title;
    private Lecturer lecturer;
    private final List<Student> studentList;
    private final int MAX_CAPACITY = 10;

    public Course(String title, Lecturer lecturer)
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

    public Lecturer getLecturer()
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
}