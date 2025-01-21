package TULO.Routines;

import TULO.Achievements.Goal;
import TULO.Achievements.Task;
import TULO.Enums.Frequency;
import TULO.Enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoutineTest
{
    private Routine routine;
    private Goal goal;
    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp()
    {
        this.routine = new Routine("Morning Time", Frequency.DAILY);
        this.goal = new Goal("Winter Cleaning");
        this.task1 = new Task("Vaccuming the room");
        this.task2 = new Task("Clean up the surface");
    }

    @Test
    void setFrequency()
    {
        assertEquals(Frequency.DAILY, routine.getFrequency());
        routine.setFrequency(Frequency.WEEKLY);
        assertEquals(Frequency.WEEKLY, routine.getFrequency());
        routine.setFrequency(Frequency.MONTHLY);
        assertEquals(Frequency.MONTHLY, routine.getFrequency());
        routine.setFrequency(Frequency.YEARLY);
        assertEquals(Frequency.YEARLY, routine.getFrequency());
    }

    @Test
    void setEndTime()
    {
        assertEquals(LocalDate.now().plusDays(1), routine.getEndTime());
        routine.setEndTime(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.of(2025,1,21), routine.getEndTime());
    }

    @Test
    void setStartTime()
    {
        assertEquals(LocalDate.now(), routine.getStartTime());
        routine.setStartTime(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.of(2025,1,21), routine.getStartTime());
    }

    @Test
    void setDescription()
    {
        assertEquals(null, routine.getDescription());
        routine.setDescription("Go to sleep before midnight");
        assertEquals("Go to sleep before midnight", routine.getDescription());
    }

    @Test
    void setName()
    {
        assertEquals("Morning Time", routine.getName());
        routine.setName("Night Time");
        assertEquals("Night Time", routine.getName());
    }

    @Test
    void removeGoal()
    {
        this.routine.addGoal(goal);
        assertEquals(1, this.routine.getGoal().size());
        assertTrue(this.routine.getGoal().contains(goal));
        this.routine.removeGoal(goal);
        assertFalse(this.routine.getGoal().contains(goal));
        assertEquals(0, this.routine.getGoal().size());
    }

    @Test
    void checkRoutineProgressCompleted()
    {
        this.routine.addGoal(goal);
        this.goal.addTask(task1);
        this.goal.addTask(task2);
        assertEquals(0, goal.checkProgress());

        this.task1.setStatus(Status.COMPLETED);
        this.task2.setStatus(Status.COMPLETED);

        assertEquals(100, goal.checkProgress());
        this.routine.checkRoutineProgress();
    }

    @Test
    void checkRoutineProgressInCompleted()
    {
        this.routine.addGoal(goal);
        this.goal.addTask(task1);
        this.goal.addTask(task2);
        assertEquals(0, goal.checkProgress());

        this.task1.setStatus(Status.COMPLETED);

        assertEquals(50, goal.checkProgress());
        this.routine.checkRoutineProgress();
    }

    @Test
    void constructorSetsDefaultValues()
    {
        assertNotNull(routine.getStartTime());
        assertNotNull(routine.getEndTime());
        assertEquals("Morning Time", routine.getName());
    }
}