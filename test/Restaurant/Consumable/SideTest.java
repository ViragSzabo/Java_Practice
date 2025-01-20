package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SideTest {
    public Consumable side;

    @BeforeEach
    void setUp()
    {
        this.side = new Side("Fries", 5);
    }

    @Test
    void calculateCalories()
    {
        assertEquals("Fries", this.side.getName());
        assertEquals(5, this.side.price);
        this.side.setName("Curly Fries");
        this.side.setPrice(7.5);
        assertEquals("Curly Fries", this.side.getName());
        assertEquals(7.5, this.side.price);
        assertNotEquals("Fries", this.side.getName());
        assertNotEquals(5, this.side.price);
    }
}