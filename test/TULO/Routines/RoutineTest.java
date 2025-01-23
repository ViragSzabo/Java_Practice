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
    void constructorSetsDeadline()
    {
        Routine dailyRoutine = new Routine("Daily Routine", Frequency.DAILY);
        assertEquals(LocalDate.now().plusDays(1), dailyRoutine.getEndTime());

        Routine weeklyRoutine = new Routine("Weekly Routine", Frequency.WEEKLY);
        assertEquals(LocalDate.now().plusWeeks(1), weeklyRoutine.getEndTime());

        Routine monthlyRoutine = new Routine("Monthly Routine", Frequency.MONTHLY);
        assertEquals(LocalDate.now().plusMonths(1), monthlyRoutine.getEndTime());

        Routine yearlyRoutine = new Routine("Yearly Routine", Frequency.YEARLY);
        assertEquals(LocalDate.now().plusYears(1), yearlyRoutine.getEndTime());
    }

    @Test
    void setFrequency()
    {
        routine.setFrequency(Frequency.WEEKLY);
        assertEquals(Frequency.WEEKLY, routine.getFrequency());
        routine.setFrequency(Frequency.MONTHLY);
        assertEquals(Frequency.MONTHLY, routine.getFrequency());
        routine.setFrequency(Frequency.YEARLY);
        assertEquals(Frequency.YEARLY, routine.getFrequency());
        assertNotEquals(Frequency.DAILY, routine.getFrequency());
    }

    @Test
    void setEndTime()
    {
        assertEquals(LocalDate.now().plusDays(1), routine.getEndTime());
        routine.setEndTime(LocalDate.of(2025,1,22).minusDays(1));
        assertEquals(LocalDate.of(2025,1,21), routine.getEndTime());
    }

    @Test
    void setStartTime()
    {
        assertEquals(LocalDate.now(), routine.getStartTime());
        routine.setStartTime(LocalDate.of(2025,1,23).minusDays(1));
        assertEquals(LocalDate.of(2025,1,22), routine.getStartTime());
    }

    @Test
    void setDescription()
    {
        routine.setDescription("Go to sleep before midnight");
        assertEquals("Go to sleep before midnight", routine.getDescription());
    }

    @Test
    void setName()
    {
        routine.setName("Night Time");
        assertEquals("Night Time", routine.getName());
    }

    @Test
    void testAddGoal() {
        assertEquals(0, routine.getGoal().size());
        routine.addGoal(goal);
        assertEquals(1, routine.getGoal().size());
        assertTrue(routine.getGoal().contains(goal));
    }

    @Test
    void testRemoveGoal() {
        routine.addGoal(goal);
        assertEquals(1, routine.getGoal().size());
        routine.removeGoal(goal);
        assertEquals(0, routine.getGoal().size());
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

        this.task1.setStatus(Status.COMPLETED);
        assertEquals(50, goal.checkProgress());
        this.routine.checkRoutineProgress();
    }

    @Test
    void constructorSetsDefaultValues()
    {
        assertEquals("Morning Time", routine.getName());
        assertEquals(Frequency.DAILY, routine.getFrequency());
        assertEquals(LocalDate.now(), routine.getStartTime());
        assertEquals(LocalDate.now().plusDays(1), routine.getEndTime());
        assertNotNull(routine.getGoal());
    }

    @Test
    void testRoutineProgressWithDeadlineMismatch()
    {
        goal.addTask(task1);
        task1.setStatus(Status.COMPLETED);

        goal.setDeadline(LocalDate.now().plusDays(1));
        routine.addGoal(goal);
        routine.checkRoutineProgress();
    }
}