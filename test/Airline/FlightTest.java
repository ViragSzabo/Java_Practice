package Airline;

import Airline.Flights.Flight;
import Airline.Passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest
{
    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    void setUp()
    {
        flight = new Flight("ABC123", "BUD");
        this.passenger = new Passenger
                ("Niall", "Horan",
                        LocalDate.of(1993, 9, 13),
                        "GFL567");    }

    @Test
    void setFlightNumber()
    {
        assertEquals("ABC123", flight.getFlightNumber());
        flight.setFlightNumber("KLM987");
        assertEquals("KLM987", flight.getFlightNumber());
    }

    @Test
    void setDestination()
    {
        assertEquals("BUD", flight.getDestination());
        flight.setDestination("PAR");
        assertEquals("PAR", flight.getDestination());
    }

    @Test
    void removePassenger()
    {
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());

        flight.removePassenger(passenger);
        assertEquals(0, flight.getPassengers().size());

        assertThrows(IllegalArgumentException.class, () -> flight.removePassenger(passenger));

        int capacity = 50;
        while(capacity > 0)
        {
            flight.addPassenger(new Passenger(
                    "John" + capacity,
                    "Doe" + capacity,
                    LocalDate.now(),
                    "123ABC" + capacity
            ));
            capacity--;
        }
        assertEquals(50, flight.getPassengers().size());
        assertThrows(IllegalArgumentException.class, () -> flight.addPassenger(passenger));
    }
}