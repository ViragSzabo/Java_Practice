package Airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        this.passenger = new Passenger("Niall", "Horan", LocalDate.of(1993, 9, 13), "GFL567");
    }

    @Test
    void setLastName() {
        assertEquals("Horan", passenger.getLastName());
        passenger.setLastName("Payne");
        assertEquals("Payne", passenger.getLastName());
    }

    @Test
    void setFirstName() {
        assertEquals("Niall", passenger.getFirstName());
        passenger.setFirstName("Liam");
        assertEquals("Liam", passenger.getFirstName());
    }

    @Test
    void setBirthDate() {
        assertEquals(31, passenger.getAge());
        passenger.setBirthDate(LocalDate.of(1993, 8, 29));
        assertEquals(31, passenger.getAge());
    }

    @Test
    void setPassportNumber() {
        assertEquals("GFL567", passenger.getPassportNumber());
        passenger.setPassportNumber("12345");
        assertEquals("12345", passenger.getPassportNumber());
    }
}