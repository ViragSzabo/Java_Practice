package TULO.Achievements;

import TULO.Enums.Priority;
import TULO.Enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;

public class Goal
{
    /** Specific parameters of the goal */
    private String name;
    private String description;
    private LocalDate deadline;
    private double progress;
    private final ArrayList<Task> tasks;

    /** Constructor of the goal */
    public Goal(String name)
    {
        this.name = name;
        this.description = "";
        this.deadline = LocalDate.now();
        this.progress = 0;
        this.tasks = new ArrayList<>();
    }

    /**
     * Get the name of the goal
     * @return a string of values
     */
    public String getName()
    {
        return name;
    }

    /** Change the name of the goal */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the description of the goal
     * @return a string of values
     */
    public String getDescription()
    {
        return description;
    }

    /** Change the description of the goal */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the deadline of the goal
     * @return a string of values
     */
    public LocalDate getDeadline()
    {
        return deadline;
    }

    /** Change the deadline of the goal */
    public void setDeadline(LocalDate deadline)
    {
        this.deadline = deadline;
    }

    /**
     * Get the progress of the goal
     * @return a double of values
     */
    public double getProgress()
    {
        return progress;
    }

    /** Change the progress of the goal */
    public void setProgress(double progress)
    {
        this.progress = progress;
    }

    /**
     * Get the list of tasks of the goal
     * @return an arraylist
     */
    public ArrayList<Task> getTasks()
    {
        return tasks;
    }

    /** Add a new task to the goal */
    public void addTask(Task task)
    {
        tasks.add(task);
    }

    /** Remove a new task to the goal */
    public void removeTask(Task task)
    {
        tasks.remove(task);
    }

    /** Show all tasks by a specific priority */
    public void displayTaskByPriority(Priority priority)
    {
        System.out.println("Show all " + priority + " tasks");
        for(Task task : tasks)
        {
            if(priority == Priority.HIGH)
            {
                System.out.println(task.getName() + ": " + task.getStatus());
            } else if (priority == Priority.MEDIUM)
            {
                System.out.println(task.getName() + ": " + task.getStatus());
            } else {
                System.out.println(task.getName() + ": " + task.getStatus());
            }
        }
    }

    /** Check the progress of the goal in percentage (%) */
    public double checkProgress()
    {
        int countCompleted = 0;
        for(Task task : tasks)
        {
            if(task.getStatus() == Status.COMPLETED)
            {
                countCompleted++;
            }
        }
        double percentage = ((double) countCompleted / tasks.size()) * 100;
        setProgress(percentage);
        return percentage;
    }
}