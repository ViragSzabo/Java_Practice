package Airline.Passengers;

import java.time.LocalDate;

public class Business extends Passenger implements Payment
{
    private final double BUSINESS_DISCOUNT = 0.50;
    public Business(String firstName, String lastName, LocalDate birthDate, String passportNumber) {
        super(firstName, lastName, birthDate, passportNumber);
    }

    @Override
    public double pay() {
        return 400 - (400 * BUSINESS_DISCOUNT);
    }
}