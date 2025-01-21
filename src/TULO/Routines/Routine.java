package TULO.Routines;

import TULO.Achievements.Goal;
import TULO.Enums.Frequency;

import java.time.LocalDate;
import java.util.ArrayList;

public class Routine
{
    /** Parameters of the Routine */
    private String name;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private Frequency frequency;
    private final ArrayList<Goal> goals;

    /** Constructor of the Routine */
    public Routine(String name, Frequency frequency)
    {
        this.name = name;
        this.goals = new ArrayList<>();
        this.frequency = frequency;
        this.startTime = LocalDate.now();

        if(frequency.equals(Frequency.DAILY))
        {
            this.endTime = LocalDate.now().plusDays(1);
        } else if (frequency.equals(Frequency.WEEKLY))
        {
            this.endTime = LocalDate.now().plusWeeks(1);
        } else if(frequency.equals(Frequency.MONTHLY))
        {
            this.endTime = LocalDate.now().plusMonths(1);
        } else
        {
            this.endTime = LocalDate.now().plusYears(1);
        }
    }

    /**
     * Get the frequency of the routine
     */
    public Frequency getFrequency()
    {
        return frequency;
    }

    /**
     * Change the name of the routine
     */
    public void setFrequency(Frequency frequency)
    {
        this.frequency = frequency;
    }

    /**
     * Get the name of the routine
     */
    public String getName()
    {
        return name;
    }

    /**
     * Change the name of the routine
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the description of the routine
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Change the name of the routine
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the startTime of the routine
     */
    public LocalDate getStartTime()
    {
        return startTime;
    }

    /**
     * Change the name of the routine
     */
    public void setStartTime(LocalDate startTime)
    {
        this.startTime = startTime;
    }

    /**
     * Get the endTime of the routine
     */
    public LocalDate getEndTime()
    {
        return endTime;
    }

    /**
     * Change the name of the routine
     */
    public void setEndTime(LocalDate endTime)
    {
        this.endTime = endTime;
    }

    /**
     * Get the goal of the routine
     */
    public ArrayList<Goal> getGoal()
    {
        return this.goals;
    }

    /**
     * Add new goal to the list of the routine
     */
    public void addGoal(Goal goal)
    {
        this.goals.add(goal);
    }

    /**
     * Remove a goal from the list of the routine
     */
    public void removeGoal(Goal goal)
    {
        this.goals.remove(goal);
    }

    /**
     * Check the progress of the routine
     */
    public void checkRoutineProgress()
    {
        for(Goal goal : goals)
        {
            if(goal.checkProgress() == 100.0 && goal.getDeadline().equals(endTime))
            {
                System.out.println("Routine " + name + " completed.");
            }
            else
            {
                System.out.println("Routine " + name + " failed.");
            }
        }
    }
}