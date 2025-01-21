package TULO.Routines;

import TULO.Achievements.Goal;

import java.util.ArrayList;

public class Organizer
{
    /** Parameter of the Organizer */
    private final ArrayList<Routine> routines;

    /** Constructor of the Organizer */
    public Organizer()
    {
        routines = new ArrayList<>();
    }

    /**
     * Get the routines of the organizer
     * @return a list of routines
     */
    public ArrayList<Routine> getRoutines()
    {
        return routines;
    }

    /**
     * Add a new routine to the list of the organizer
     */
    public void addRoutine(Routine routine)
    {
        routines.add(routine);
    }

    /**
     * Remove a routine from the list of the organizer
     */
    public void removeRoutine(Routine routine)
    {
        routines.remove(routine);
    }

    public void displayReminder()
    {
        for(Routine routine : routines)
        {
            System.out.println(routine.getName()
                    + ": " + routine.getStartTime()
                    + " and " + routine.getEndTime());
        }
    }
}