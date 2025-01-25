package Brooklyn99.Station;

import Brooklyn99.Enums.Ranks;
import Brooklyn99.Exceptions.CASE_NOT_FOUND;
import Brooklyn99.Roles.Detective;
import Brooklyn99.Roles.PolicePersonnel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliceStationTest
{
    private PoliceStation station;
    private Detective detective;
    private Case newCase;

    @BeforeEach
    void setUp()
    {
        station = new PoliceStation();
        detective = new Detective("Rosa", 5432345, Ranks.MIDDLE);
        newCase = new Case(123, "Peeing at the church");
    }

    @Test
    void addNewPerson()
    {
        assertEquals(0, station.getPeople().size());
        station.addNewPerson(detective);
        assertEquals(1, station.getPeople().size());
        station.removePerson(detective);
        assertEquals(0, station.getPeople().size());
    }

    @Test
    void assignCaseToDetective() throws CASE_NOT_FOUND
    {
        station.addNewPerson(detective);
        station.assignCaseToDetective(newCase, detective);
        assertEquals(1, station.getCases().size());
        assertFalse(newCase.isSolved());
        newCase.markAsSolved();
        station.assignCaseToDetective(newCase, detective);
        assertTrue(newCase.isSolved());
        station.removeCase(newCase);
        assertThrows(CASE_NOT_FOUND.class, () -> station.removeCase(newCase));
    }
}