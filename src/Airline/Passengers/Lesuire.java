package Airline.Passengers;

import java.time.LocalDate;

public class Lesuire extends Passenger implements Payment
{
    public Lesuire(String firstName, String lastName, LocalDate birthDate, String passportNumber)
    {
        super(firstName, lastName, birthDate, passportNumber);
    }

    @Override
    public double pay()
    {
        return 250;
    }
}