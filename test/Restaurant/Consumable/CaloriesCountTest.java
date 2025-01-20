package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaloriesCountTest {
    public CaloriesCount pizza;
    public CaloriesCount side;
    public CaloriesCount drink;

    @BeforeEach
    void setUp()
    {
        this.pizza = new Pizza("Dalma", 11.99);
        this.side = new Side("Fries", 5.0);
        this.drink = new Drink("Cola", 2.5);
    }

    @Test
    void calculateCalories()
    {
        assertEquals(500, pizza.calculateCalories());
        assertEquals(250, side.calculateCalories());
        assertEquals(50, drink.calculateCalories());
    }
}