package TULO.Achievements;

import TULO.Enums.Priority;
import TULO.Enums.Status;

public class Task
{
    /** Specific parameters of the task */
    private String name;
    private Priority priority;
    private Status status;

    /** Constructor of the task */
    public Task(String name)
    {
        this.name = name;
        this.priority = Priority.LOW;
        this.status = Status.PENDING;
    }

    /**
     * Get the name of the task
     * @return a string of values
     */
    public String getName()
    {
        return name;
    }

    /** Change the name of the task */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the priority of the task
     * @return a priority value
     */
    public Priority getPriority()
    {
        return priority;
    }

    /** Change the priority of the task */
    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    /**
     * Get the status of the task
     * @return a status value
     */
    public Status getStatus()
    {
        return status;
    }

    /** Change the status of the task */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /** Mark the status of the task complete */
    public void markComplete()
    {
        setStatus(Status.COMPLETED);
    }

    /** Mark the status of the task in progress */
    public void markInProgress()
    {
        setStatus(Status.IN_PROGRESS);
    }
}