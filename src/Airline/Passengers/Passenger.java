package Airline.Passengers;

import java.time.LocalDate;
import java.time.Period;

public class Passenger
{
    /** Parameters of Passenger */
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String passportNumber;

    /** Constructor of Passenger */
    public Passenger(String firstName, String lastName, LocalDate birthDate, String passportNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
    }

    /**
     * Get the last name of the passenger
     * @return a string
     */
    public String getLastName()
    {
        return lastName;
    }

    /** Change the last name of the passenger */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the first name of the passenger
     * @return a string
     */
    public String getFirstName()
    {
        return firstName;
    }

    /** Change the first name of the passenger */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Calculate the age of the passenger from their birthdate
     * @return an integer
     */
    public int getAge()
    {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /** Change the birthdate if there is any mistyped happened earlier */
    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    /**
     * Get the passport number of the passenger
     * @return a string
     */
    public String getPassportNumber()
    {
        return passportNumber;
    }

    /** Change the passport number of the passenger if there are any mistyped happened */
    public void setPassportNumber(String passportNumber)
    {
        this.passportNumber = passportNumber;
    }
}