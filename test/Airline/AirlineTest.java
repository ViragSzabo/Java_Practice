package Airline;

import Airline.Airlines.Airline;
import Airline.Airlines.Types;
import Airline.Exceptions.InvalidData;
import Airline.Flights.Flight;
import Airline.Passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AirlineTest
{
    private Airline airline;
    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    void setUp()
    {
        this.airline = new Airline();
        this.flight = new Flight("ABC123", "BUD");
        this.passenger = new Passenger
                ("Niall", "Horan",
                        LocalDate.of(1993, 9, 13),
                        "GFL567");    }

    @Test
    void setType()
    {
        assertEquals(Types.NOT_SPECIFY, airline.getType());
        airline.setType(Types.KLM);
        assertEquals(Types.KLM, airline.getType());
    }

    @Test
    void removeFlight()
    {
        airline.addFlight(flight);
        assertEquals(1, airline.getFlights().size());
        assertThrows(IllegalArgumentException.class, () -> airline.removeFlight("KLM965"));
        try {
            airline.removeFlight(flight.getFlightNumber());
        } catch (InvalidData e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void bookFlight()
    {
        airline.addFlight(flight);
        try {
            airline.bookFlight(passenger, flight.getFlightNumber());
        } catch (InvalidData e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalArgumentException.class, () -> airline.bookFlight(passenger, "KLM956"));
    }

    @Test
    void cancelBooking()
    {
        airline.addFlight(flight);
        try {
            airline.bookFlight(passenger, flight.getFlightNumber());
        } catch (InvalidData e) {
            throw new RuntimeException(e);
        }
        assertEquals(1, airline.getFlights().size());
        try {
            airline.cancelBooking(passenger, flight.getFlightNumber());
        } catch (InvalidData e) {
            throw new RuntimeException(e);
        }
        assertThrows(InvalidData.class, () -> airline.cancelBooking(passenger, "KLM956"));
    }
}