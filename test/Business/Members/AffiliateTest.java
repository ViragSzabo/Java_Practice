package Business.Members;

import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffiliateTest
{
    private Member person;

    @BeforeEach
    void setUp()
    {
        this.person = new Affiliate("Nick");
    }

    @Test
    void calculateEarnings()
    {
        try {
            assertEquals(150, this.person.calculateEarnings());
        } catch (CALCULATE_EARNINGS_WITHOUT_SALE e) {
            assertThrows(CALCULATE_EARNINGS_WITHOUT_SALE.class, () -> person.calculateEarnings());
        }
    }
}