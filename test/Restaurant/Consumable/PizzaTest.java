package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    public Consumable pizza;

    @BeforeEach
    void setUp() {
        this.pizza = new Pizza("Dalma", 11.99);
    }

    @Test
    void calculateCalories() {
        assertEquals(119.9, this.pizza.calculateCalories());
    }
}