package Restaurant.Consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumableTest {
    public Consumable pizza;
    public Consumable side;
    public Consumable drink;

    @BeforeEach
    void setUp() {
        this.pizza = new Pizza("Dalma", 11.99);
        this.side = new Side("Fries", 5.0);
        this.drink = new Drink("Cola", 2.5);
    }

    @Test
    void getName() {
        assertEquals("Dalma", pizza.getName());
        assertEquals("Fries", side.getName());
        assertEquals("Cola", drink.getName());
    }

    @Test
    void setName() {
        pizza.setName("Bence");
        assertEquals("Bence", pizza.getName());
        drink.setName("Water");
        assertEquals("Water", drink.getName());
        side.setName("Salad");
        assertEquals("Salad", side.getName());
    }

    @Test
    void getPrice() {
        assertEquals(11.99, pizza.getPrice());
        assertEquals(5.0, side.getPrice());
        assertEquals(2.5, drink.getPrice());
    }

    @Test
    void setPrice() {
        pizza.setPrice(10.0);
        assertEquals(10.0, pizza.getPrice());
        drink.setPrice(1.0);
        assertEquals(1.0, drink.getPrice());
        side.setPrice(3.0);
        assertEquals(3.0, side.getPrice());
    }

    @Test
    void calculateCalories() {
        assertEquals(119.9, pizza.calculateCalories());
        assertEquals(25.0, side.calculateCalories());
        assertEquals(5.0, drink.calculateCalories());
    }
}