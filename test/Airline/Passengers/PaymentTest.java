package Airline.Passengers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PaymentTest
{
    private Payment passenger;
    private Payment passenger2;

    @BeforeEach
    void setUp()
    {
        this.passenger = new Business(
                "Niall", "Horan",
                LocalDate.of(1993, 9, 13),
                "GFL567");
        this.passenger2 = new Lesuire(
                "Amanda", "Horan",
                LocalDate.of(1993, 9, 13),
                "GFL567");
    }

    @Test
    void pay()
    {
        assertEquals(200, passenger.pay());
        assertEquals(250, passenger2.pay());
        assertNotEquals(400, passenger.pay());
    }
}