package Learning;

import Learning.Exceptions.LecturerNotFound;
import Learning.People.Lecturer;
import Learning.People.Student;

import java.util.ArrayList;
import java.util.List;

public class Platform
{
    private String name;
    private final List<Course> allCourses;
    private final List<Student> allStudents;
    private final List<Lecturer> allLecturers;

    public Platform(String name)
    {
        this.name = name;
        this.allCourses = new ArrayList<>();
        this.allStudents = new ArrayList<>();
        this.allLecturers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Course> getAllCourses()
    {
        return allCourses;
    }

    public void addCourses(Course course)
    {
        allCourses.add(course);
    }

    public void removeCourse(Course course)
    {
        allCourses.remove(course);
    }

    public List<Student> getAllStudents()
    {
        return allStudents;
    }

    public void registerStudentToSchool(Student student)
    {
        allStudents.add(student);
    }

    public void removeStudentFromSchool(Student student)
    {
        allStudents.remove(student);
    }

    public List<Lecturer> getAllLecturers()
    {
        return allLecturers;
    }

    public void addLecturerToSchool(Lecturer lecturer)
    {
        allLecturers.add(lecturer);
    }

    public void removeLecturerFromSchool(Lecturer lecturer)
    {
        allLecturers.remove(lecturer);
    }

    public void findCoursesBy(Lecturer lecturer) throws LecturerNotFound
    {
        boolean found = false;
        for(Course course : allCourses)
        {
            if(course.getLecturer().equals(lecturer))
            {
                System.out.println(lecturer.getFirstName() + " " + lecturer.getLastName() + "'s course(s) "
                        + lecturer.getCoursesToTeach().size() + " found");
                System.out.println(course.getTitle());
                found = true;
            }
        }
        if(!found)
        {
            throw new LecturerNotFound("Lecturer was not found");
        }
    }
}