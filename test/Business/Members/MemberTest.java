package Business.Members;

import Business.Exceptions.ADD_EXISTED_MEMBER;
import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;
import Business.Exceptions.REMOVE_NOT_EXISTED_MEMBER;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest
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
        partner.setLevel(Levels.BRONZE);

        try {
            person.addMembers(affiliate);
            assertThrows(ADD_EXISTED_MEMBER.class, () -> person.addMembers(affiliate));
        } catch (ADD_EXISTED_MEMBER e) {
            fail("Unexpected exception in setUp: " + e.getMessage());
        }
    }

    @Test
    void setName()
    {
        person.setName("Micholas");
        assertEquals("Micholas", person.getName());
        assertNotEquals("Mich", person.getName());
    }

    @Test
    void setLevel()
    {
        person.setLevel(Levels.GOLD);
        assertEquals(Levels.GOLD, person.getLevel());
        assertNotEquals(Levels.SILVER, person.getLevel());
    }

    @Test
    void addMembers()
    {
        try
        {
            person.addMembers(partner);
            assertTrue(person.getMembers().contains(partner));
            assertEquals(2, person.getMembers().size());
        } catch (ADD_EXISTED_MEMBER e) {
            fail("Unexpected exception in addMembers: " + e.getMessage());
        }
    }

    @Test
    void removeMembers()
    {
        try
        {
            person.addMembers(partner);
            person.removeMembers(partner);

            assertFalse(person.getMembers().contains(partner));
            assertEquals(1, person.getMembers().size());

            assertThrows(REMOVE_NOT_EXISTED_MEMBER.class, () -> person.removeMembers(partner));
        } catch (REMOVE_NOT_EXISTED_MEMBER | ADD_EXISTED_MEMBER e)
        {
            fail("Unexpected exception in removeMembers: " + e.getMessage());
        }
    }

    @Test
    void showDownlines()
    {
        person.showDownlines();
        assertEquals(1, person.getMembers().size());
        assertTrue(person.getMembers().contains(affiliate));
    }

    @Test
    void calculateTotalEarnings()
    {
        try
        {
            assertEquals(0.0, affiliate.calculateTotalEarnings());
        } catch (CALCULATE_EARNINGS_WITHOUT_SALE e) {
            fail("Unexpected exception for affiliate: " + e.getMessage());
        }

        person.addSales(1000);

        try
        {
            assertEquals(150.0, person.calculateTotalEarnings());
        } catch (CALCULATE_EARNINGS_WITHOUT_SALE e) {
            fail("Unexpected exception for person: " + e.getMessage());
        }
    }

    @Test
    void calculateEarningsWithoutSales()
    {
        Distributor noSalesDistributor = new Distributor("Bogi");
        assertThrows(CALCULATE_EARNINGS_WITHOUT_SALE.class, noSalesDistributor::calculateEarnings);
    }

    @Test
    void emptyDownLines()
    {
        Distributor emptyDistributor = new Distributor("Emese");
        emptyDistributor.addSales(500);

        try
        {
            assertEquals(0.0, emptyDistributor.calculateTotalEarnings());
        } catch (CALCULATE_EARNINGS_WITHOUT_SALE e) {
            fail("Unexpected exception for empty downlines: " + e.getMessage());
        }
    }
}