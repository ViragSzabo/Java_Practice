package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    public Consumable pizza;

    @BeforeEach
    void setUp()
    {
        this.pizza = new Pizza("Dalma", 11.99);
    }

    @Test
    void calculateCalories()
    {
        assertEquals("Dalma", this.pizza.getName());
        assertEquals(11.99, this.pizza.price);
        this.pizza.setName("Double-Cheese Dalma");
        this.pizza.setPrice(13.0);
        assertEquals("Double-Cheese Dalma", this.pizza.getName());
        assertEquals(13.0, this.pizza.price);
        assertNotEquals("Dalma", this.pizza.getName());
        assertNotEquals(11.99, this.pizza.price);
    }
}