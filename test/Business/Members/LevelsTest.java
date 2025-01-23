package Business.Members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelsTest {

    @Test
    void getCommisionRate()
    {
        assertEquals(0.0, Levels.STARTUP.getCommisionRate());
        assertEquals(0.10, Levels.SILVER.getCommisionRate());
        assertEquals(0.05, Levels.BRONZE.getCommisionRate());
        assertEquals(0.20, Levels.PLATINUM.getCommisionRate());
        assertEquals(0.15, Levels.GOLD.getCommisionRate());
    }
}