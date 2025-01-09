package Learning;

import java.time.LocalDate;
import java.time.Period;

public class Student
{
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private String email;
    private String phone;

    public Student(String firstName, String lastName, LocalDate birthdate,
                   String gender, String email, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate)
    {
        this.birthdate = birthdate;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return calculateAge();
    }

    private int calculateAge()
    {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}