package Learning.People;

import Learning.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LecturerTest {
    public Course course;
    public Lecturer lecturer1;

    @BeforeEach
    void setUp() {
        lecturer1 = new Lecturer("Mario", "Handson", LocalDate.of(1970,5,18),
                "Male", "m.handson@gmail.com", "+31678654932", 5000);
        course = new Course("Dutch B2", lecturer1);
    }

    @Test
    void setSalary() {
        assertEquals(5000, lecturer1.getSalary());
        lecturer1.setSalary(6500);
        assertEquals(6500, lecturer1.getSalary());
    }
}