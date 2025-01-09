package Learning.People;

import Learning.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest
{
    public Student student1;
    public Course course;
    public Lecturer lecturer1;

    @BeforeEach
    void setUp()
    {
        student1 = new Student("", "", LocalDate.now(), "", "", "");
        lecturer1 = new Lecturer("", "", LocalDate.now(), "", "", "", 5000);
        course = new Course("", lecturer1);
    }

    @Test
    void setFirstName()
    {
        student1.setFirstName("Bruno");
        assertEquals("Bruno", student1.getFirstName());
        assertNotEquals("", student1.getFirstName());
    }

    @Test
    void setLastName()
    {
        student1.setLastName("Mars");
        assertEquals("Mars", student1.getLastName());
        assertNotEquals("", student1.getLastName());
    }
    @Test
    void setBirthdate()
    {
        student1.setBirthdate(LocalDate.of(1985,10,8));
        assertEquals(LocalDate.of(1985,10,8), student1.getBirthdate());
        assertNotEquals(LocalDate.now(), student1.getBirthdate());
    }

    @Test
    void setGender()
    {
        student1.setGender("Male");
        assertEquals("Male", student1.getGender());
        assertNotEquals("", student1.getGender());
    }
    @Test
    void setPhone()
    {
        student1.setPhone("+1 (808) 798-3132");
        assertEquals("+1 (808) 798-3132", student1.getPhone());
        assertNotEquals("", student1.getPhone());
    }

    @Test
    void setEmail()
    {
        student1.setEmail("bruno.mars.offical@gmail.com");
        assertEquals("bruno.mars.offical@gmail.com", student1.getEmail());
        assertNotEquals("", student1.getEmail());
    }

    @Test
    void getAge()
    {
        student1.setBirthdate(LocalDate.of(1985,10,8));
        assertEquals(39, student1.getAge());
    }

    @Test
    void getPay()
    {
        student1.apply(course);
        assertEquals(250.0, student1.getPay());
    }

    @Test
    void apply()
    {
        assertEquals(0, student1.getCourses().size());
        student1.apply(course);
        assertEquals(1, student1.getCourses().size());
    }
}