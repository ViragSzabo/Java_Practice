package Learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest
{
    public Student student1;

    @BeforeEach
    void setUp()
    {
        student1 = new Student("", "", LocalDate.now(), "", "", "");
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
}