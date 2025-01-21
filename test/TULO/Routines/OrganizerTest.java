package TULO.Routines;

import TULO.Achievements.Goal;
import TULO.Achievements.Task;
import TULO.Enums.Frequency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerTest
{
    private Organizer organizer;
    private Routine routine;
    private Goal goal;
    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp()
    {
        this.organizer = new Organizer();
        this.routine = new Routine("Morning Time", Frequency.DAILY);
        this.goal = new Goal("Winter Cleaning");
        this.task1 = new Task("Vaccuming the room");
        this.task2 = new Task("Clean up the surface");
    }

    @Test
    void removeRoutine()
    {
        assertEquals(0, organizer.getRoutines().size());
        organizer.addRoutine(routine);
        routine.addGoal(goal);
        goal.addTask(task1);
        goal.addTask(task2);
        assertEquals(1, organizer.getRoutines().size());
        organizer.displayReminder();
        organizer.removeRoutine(routine);
        assertNotEquals(1, organizer.getRoutines().size());
    }
}