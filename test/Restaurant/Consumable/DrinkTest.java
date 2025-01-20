package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    public Consumable drink;

    @BeforeEach
    void setUp()
    {
        this.drink = new Drink("Cola", 2.5);
    }

    @Test
    void calculateCalories()
    {
        assertEquals("Cola", this.drink.getName());
        assertEquals(2.5, this.drink.price);
        this.drink.setName("Coca Cola");
        this.drink.setPrice(3.5);
        assertEquals("Coca Cola", this.drink.getName());
        assertEquals(3.5, this.drink.price);
        assertNotEquals("Cola", this.drink.getName());
        assertNotEquals(2.5, this.drink.price);
    }
}