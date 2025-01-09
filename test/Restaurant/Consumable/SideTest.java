package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SideTest {
    public Consumable side;

    @BeforeEach
    void setUp() {
        this.side = new Side("Fries", 5);
    }

    @Test
    void calculateCalories() {
        assertEquals(25, this.side.calculateCalories());
    }
}