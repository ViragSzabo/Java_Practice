package Brooklyn99.Station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseTest
{
    private Case specificCase;

    @BeforeEach
    void setUp()
    {
        this.specificCase = new Case(123, "Peeing at the church");
    }

    @Test
    void setCaseData()
    {
        specificCase.setCaseID(1);
        specificCase.setDetails("Open peeing");
        assertEquals(1, specificCase.getCaseID());
        assertEquals("Open peeing", specificCase.getDetails());
        specificCase.getCaseInfo();
    }

    @Test
    void markAsSolved()
    {
        assertFalse(specificCase.isSolved());
        specificCase.markAsSolved();
        assertTrue(specificCase.isSolved());
    }
}