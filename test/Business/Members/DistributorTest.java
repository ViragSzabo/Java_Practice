package Business.Members;

import Business.Exceptions.ADD_EXISTED_MEMBER;
import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributorTest
{
    private Distributor person;
    private Distributor partner;
    private Affiliate affiliate;

    @BeforeEach
    void setUp()
    {
        this.person = new Distributor("Mich");
        this.partner = new Distributor("Niki");
        this.affiliate =  new Affiliate("Nick");
        person.setLevel(Levels.SILVER);
        try {
            person.addMembers(partner);
            person.addMembers(affiliate);
        } catch (ADD_EXISTED_MEMBER e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addSales()
    {
        assertEquals(0, person.getSales());
        person.addSales(10);
        assertEquals(10, person.getSales());
        person.addSales(20);
        assertEquals(30, person.getSales());
    }

    @Test
    void calculateEarnings()
    {
        try {
            person.addSales(10);
            assertEquals(1.0, person.calculateEarnings());
            partner.addSales(20);
            assertEquals(2.0, person.calculateEarnings());
            assertTrue(person.getMembers().contains(partner));
            assertTrue(partner.getLevel().equals(Levels.STARTUP));
            assertEquals(3.0, person.calculateEarnings());
        } catch (CALCULATE_EARNINGS_WITHOUT_SALE e) {
            assertThrows(CALCULATE_EARNINGS_WITHOUT_SALE.class, () -> person.calculateEarnings());
        }
    }
}