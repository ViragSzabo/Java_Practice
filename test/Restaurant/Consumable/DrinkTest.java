package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    public Consumable drink;

    @BeforeEach
    void setUp() {
        this.drink = new Drink("Cola", 2.5);
    }

    @Test
    void calculateCalories() {
        assertEquals(5, this.drink.calculateCalories());
    }
}