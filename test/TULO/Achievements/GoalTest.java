package TULO.Achievements;

import TULO.Enums.Priority;
import TULO.Enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GoalTest
{
    private Goal goal;
    private Task task1;
    private Task task2;
    private Task task3;
    private Task task4;
    private Task task5;

    @BeforeEach
    void setUp()
    {
        this.goal = new Goal("Winter Cleaning");
        this.task1 = new Task("Vaccuming the room");
        this.task2 = new Task("Clean up the surface");
        this.task3 = new Task("Wash dirty clothes");
        this.task4 = new Task("Wash dirty dishes");
        this.task5 = new Task("Clean up the wardrobe");
    }

    @Test
    void setName()
    {
        this.goal.setName("Winter Deep Cleaning");
        assertEquals("Winter Deep Cleaning", this.goal.getName());
        assertNotEquals("Winter Cleaning", this.goal.getName());
    }

    @Test
    void setDescription()
    {
        assertEquals("", this.goal.getDescription());
        this.goal.setDescription("Clean up the room");
        assertEquals("Clean up the room", this.goal.getDescription());
    }

    @Test
    void setDeadline()
    {
        assertEquals(LocalDate.now(), this.goal.getDeadline());
        this.goal.setDeadline(LocalDate.of(2025, 1, 25));
        assertEquals(LocalDate.of(2025, 1, 25), this.goal.getDeadline());
    }

    @Test
    void setProgress()
    {
        assertEquals(0, this.goal.getProgress());
        this.goal.addTask(task1);
        this.goal.addTask(task2);
        this.goal.addTask(task3);
        this.goal.addTask(task4);
        this.goal.addTask(task5);
        this.task1.setStatus(Status.COMPLETED);
        this.task2.setStatus(Status.COMPLETED);
        this.task3.setStatus(Status.COMPLETED);
        this.goal.checkProgress();
        assertEquals(60, this.goal.getProgress());
    }

    @Test
    void displayTaskByPriority()
    {
        this.goal.addTask(task1);
        this.goal.addTask(task2);
        this.goal.addTask(task3);
        assertEquals(3, this.goal.getTasks().size());

        this.goal.addTask(task4);
        this.goal.addTask(task5);
        assertEquals(5, this.goal.getTasks().size());

        this.goal.removeTask(task1);
        assertEquals(4, this.goal.getTasks().size());

        this.goal.displayTaskByPriority(Priority.LOW);

        task1.setPriority(Priority.MEDIUM);
        task2.setPriority(Priority.MEDIUM);
        task3.setPriority(Priority.MEDIUM);
        this.goal.displayTaskByPriority(Priority.MEDIUM);

        task4.setPriority(Priority.HIGH);
        task5.setPriority(Priority.HIGH);
        this.goal.displayTaskByPriority(Priority.HIGH);
    }

    @Test
    void checkProgress()
    {
        this.goal.addTask(task1);
        this.goal.addTask(task2);
        this.goal.addTask(task3);
        this.goal.addTask(task4);
        this.goal.addTask(task5);
        assertEquals(5, this.goal.getTasks().size());

        this.task1.setStatus(Status.COMPLETED);
        this.task2.setStatus(Status.COMPLETED);
        this.task3.setStatus(Status.COMPLETED);
        assertEquals(60, this.goal.checkProgress());
    }
}