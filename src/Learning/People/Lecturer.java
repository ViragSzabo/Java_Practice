package Learning.People;

import java.time.LocalDate;

public class Lecturer extends Person
{
    private int salary;

    /** Constructor */
    public Lecturer(String firstName, String lastName, LocalDate birthdate,
                    String gender, String email, String phone, int salary)
    {
        super(firstName, lastName, birthdate, gender, email, phone);
        this.salary = salary;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}