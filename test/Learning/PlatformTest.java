package Learning;

import Learning.Exceptions.LecturerNotFound;
import Learning.People.Lecturer;
import Learning.People.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PlatformTest
{
    private Platform platform;
    public Course course1;
    public Course course2;
    public Course course3;
    public Lecturer lecturer1;
    public Lecturer lecturer2;
    public Student student1;
    public Student student2;

    @BeforeEach
    void setUp()
    {
        platform = new Platform("Good Dutch");
        lecturer1 = new Lecturer("Ghost", "Girls", LocalDate.now(), "", "", "", 5000);
        lecturer2 = new Lecturer("Ghost", "Stories", LocalDate.now(), "", "", "", 2000);
        course1 = new Course("Dutch B2", lecturer1);
        course2 = new Course("English B2", lecturer1);
        course3 = new Course("German B2", lecturer1);
        student1 = new Student("Bruno", "Mars", LocalDate.of(1985,10,8),
                "Male", "bruno.mars.offical@gmail.com", "+1 (808) 798-3132");
        student2 = new Student("Bianca", "Mars", LocalDate.of(1985,10,8),
                "Female", "bianva.mars.offical@gmail.com", "+1 (808) 452-7456");
    }

    @Test
    void setName()
    {
        assertEquals("Good Dutch", platform.getName());
        platform.setName("Good Dutch School");
        assertEquals("Good Dutch School", platform.getName());
    }

    @Test
    void addCourses() {
        assertEquals(0, platform.getAllCourses().size());
        platform.addCourses(course1);
        platform.addCourses(course2);
        platform.addCourses(course3);
        assertEquals(3, platform.getAllCourses().size());
        assertNotEquals(0, platform.getAllCourses().size());
    }

    @Test
    void removeCourse() {
        assertEquals(0, platform.getAllCourses().size());
        platform.addCourses(course1);
        platform.addCourses(course2);
        platform.addCourses(course3);
        assertEquals(3, platform.getAllCourses().size());
        platform.removeCourse(course1);
        assertEquals(2, platform.getAllCourses().size());
        assertNotEquals(3, platform.getAllCourses().size());
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void registerStudentToSchool() {
        assertEquals(0, platform.getAllStudents().size());
        platform.registerStudentToSchool(student1);
        assertEquals(1, platform.getAllStudents().size());
        assertNotEquals(0, platform.getAllStudents().size());
        platform.registerStudentToSchool(student2);
        assertEquals(2, platform.getAllStudents().size());
        assertNotEquals(3, platform.getAllStudents().size());
    }

    @Test
    void removeStudentFromSchool() {
        assertEquals(0, platform.getAllStudents().size());
        platform.registerStudentToSchool(student1);
        platform.registerStudentToSchool(student2);
        platform.removeStudentFromSchool(student1);
        assertEquals(1, platform.getAllStudents().size());
        assertNotEquals(2, platform.getAllStudents().size());
    }

    @Test
    void addLecturerToSchool() {
        assertEquals(0, platform.getAllLecturers().size());
        platform.addLecturerToSchool(lecturer1);
        assertEquals(1, platform.getAllLecturers().size());
    }

    @Test
    void removeLecturerFromSchool() {
        assertEquals(0, platform.getAllLecturers().size());
        platform.addLecturerToSchool(lecturer1);
        platform.addLecturerToSchool(lecturer2);
        platform.removeLecturerFromSchool(lecturer2);
        assertEquals(1, platform.getAllLecturers().size());
    }

    @Test
    void findCoursesBy() throws LecturerNotFound {
        platform.addLecturerToSchool(lecturer1);
        platform.addLecturerToSchool(lecturer2);
        platform.addCourses(course1);
        platform.addCourses(course2);
        platform.addCourses(course3);
        lecturer1.addCourse(course1);
        lecturer1.addCourse(course2);
        lecturer2.addCourse(course3);
        assertEquals(2, lecturer1.getCoursesToTeach().size());
        assertNotEquals(3, lecturer1.getCoursesToTeach().size());
        assertEquals(course1, lecturer1.getCoursesToTeach().get(0));
        assertEquals(course2, lecturer1.getCoursesToTeach().get(1));
        assertNotEquals(course3, lecturer1.getCoursesToTeach().get(1));
        platform.findCoursesBy(lecturer1);
        assertThrows(LecturerNotFound.class, () -> platform.findCoursesBy(lecturer2));
    }
}