package TULO.Achievements;

import TULO.Enums.Priority;
import TULO.Enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest
{
    private Task task;

    @BeforeEach
    void setUp()
    {
        this.task = new Task("Winter Cleaning");
    }

    @Test
    void setName()
    {
        this.task.setName("Winter Deep Cleaning");
        assertEquals("Winter Deep Cleaning", this.task.getName());
        assertNotEquals("Winter Cleaning", this.task.getName());
    }

    @Test
    void setPriority()
    {
        this.task.setPriority(Priority.HIGH);
        assertEquals(Priority.HIGH, this.task.getPriority());
        assertNotEquals(Priority.LOW, this.task.getPriority());
    }

    @Test
    void markComplete()
    {
        assertEquals(Status.PENDING, task.getStatus());
        task.markInProgress();
        assertEquals(Status.IN_PROGRESS, task.getStatus());
        task.markComplete();
        assertEquals(Status.COMPLETED, task.getStatus());
        assertNotEquals(Status.IN_PROGRESS, task.getStatus());
        assertNotEquals(Status.PENDING, task.getStatus());
    }
}