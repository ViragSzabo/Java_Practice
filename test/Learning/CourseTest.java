package Learning;

import Learning.Exceptions.MaxNumberOfStudents;
import Learning.Exceptions.StudentNotFound;
import Learning.People.Lecturer;
import Learning.People.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest
{
    public Student student1;
    public Student student2;
    public Course course;
    public Lecturer lecturer1;
    public Lecturer lecturer2;

    @BeforeEach
    void setUp()
    {
        student1 = new Student("Bruno", "Mars", LocalDate.of(1985,10,8),
                "Male", "bruno.mars.offical@gmail.com", "+1 (808) 798-3132");
        student2 = new Student("Bianca", "Mars", LocalDate.of(1985,10,8),
                "Male", "bruno.mars.offical@gmail.com", "+1 (808) 798-3132");
        lecturer1 = new Lecturer("", "", LocalDate.now(), "", "", "", 5000);
        lecturer2 = new Lecturer("", "", LocalDate.now(), "", "", "", 5000);
        course = new Course("Dutch B2", lecturer1);
    }

    @Test
    void setTitle()
    {
        assertEquals("Dutch B2", course.getTitle());
        course.setTitle("Dutch B2+");
        assertEquals("Dutch B2+", course.getTitle());
    }

    @Test
    void setLecturer() {
        assertEquals(lecturer1, course.getLecturer());
        course.setLecturer(lecturer2);
        assertEquals(lecturer2, course.getLecturer());
    }

    @Test
    void getStudentList() {
    }

    @Test
    void addStudent_Success() throws MaxNumberOfStudents {
        course.addStudent(student1);
        assertEquals(student1, course.getStudentList().get(0));
        assertEquals(1, course.getStudentList().size());
    }

    @Test
    void addStudent_Fail() throws MaxNumberOfStudents {
        course.addStudent(student1);
        course.addStudent(student2);
        assertThrows(MaxNumberOfStudents.class, () -> course.addStudent(student2));
    }

    @Test
    void removeStudent_Fail() throws StudentNotFound {
        assertThrows(StudentNotFound.class, () -> course.removeStudent(student1));
    }

    @Test
    void removeStudent_Success() throws StudentNotFound, MaxNumberOfStudents {
        course.addStudent(student1);
        course.removeStudent(student1);
    }

}