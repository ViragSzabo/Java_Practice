package Airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AirlineTest {
    private Airline airline;
    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        this.airline = new Airline("KLM");
        this.flight = new Flight("ABC123", "BUD");
        this.passenger = new Passenger("Niall", "Horan", LocalDate.of(1993, 9, 13), "GFL567");
    }

    @Test
    void setName() {
        assertEquals("KLM", airline.getName());
        airline.setName("NL-KLM");
        assertEquals("NL-KLM", airline.getName());
    }

    @Test
    void removeFlight() {
        airline.addFlight(flight);
        assertEquals(1, airline.getFlights().size());
        assertThrows(IllegalArgumentException.class, () -> airline.removeFlight("KLM965"));
        airline.removeFlight(flight.getFlightNumber());
    }

    @Test
    void bookFlight() {
        airline.addFlight(flight);
        airline.bookFlight(passenger, flight.getFlightNumber());
        assertThrows(IllegalArgumentException.class, () -> airline.bookFlight(passenger, "KLM956"));
    }

    @Test
    void cancelBooking() {
        airline.addFlight(flight);
        airline.bookFlight(passenger, flight.getFlightNumber());
        assertEquals(1, airline.getFlights().size());
        airline.cancelBooking(passenger, flight.getFlightNumber());
        assertThrows(IllegalArgumentException.class, () -> airline.cancelBooking(passenger, "KLM956"));
    }
}