package Restaurant;

import Restaurant.Consumable.Consumable;
import Restaurant.Consumable.Drink;
import Restaurant.Consumable.Pizza;
import Restaurant.Consumable.Side;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaRestaurantTest {
    public PizzaRestaurant restaurant;
    public Customer customer;
    public Consumable pizza;
    public Consumable drink;
    public Consumable side;

    @BeforeEach
    void setUp() {
        restaurant = new PizzaRestaurant("Pottcast");
        this.pizza = new Pizza("Dalma", 200.0);
        this.side = new Side("Fries", 100.0);
        this.drink = new Drink("Cola", 50.0);
        this.customer = new Customer(
                "Keanuu",
                "Reves",
                "keanu.reeves@gmail.com",
                "+447520529818",
                "16 Grove Road",
                "Hudders",
                "UK",
                "HD209LP",
                1000.0
        );
    }

    @Test
    void setName() {
        restaurant.setName("Pottcast Restaurant");
        assertEquals("Pottcast Restaurant", restaurant.getName());
    }

    @Test
    void calculateDiscount() {
        customer.addOrder(drink); //50 - less than 100
        assertEquals(50, restaurant.calculateDiscount(customer));

        customer.addOrder(side); //150 - more than 100
        assertEquals(135, restaurant.calculateDiscount(customer));
        assertNotEquals(150, restaurant.calculateDiscount(customer));

        customer.addOrder(pizza); //350 - more than 250, less than 500
        assertEquals(262.5, restaurant.calculateDiscount(customer));
        assertNotEquals(350, restaurant.calculateDiscount(customer));

        customer.addOrder(pizza);
        customer.addOrder(pizza); //750 - more than 500, less than 750
        assertEquals(375, restaurant.calculateDiscount(customer));
        assertNotEquals(750, restaurant.calculateDiscount(customer));

        customer.addOrder(pizza);
        customer.addOrder(pizza);
        customer.addOrder(pizza);
        customer.addOrder(side);
        customer.addOrder(drink); //1500
        assertEquals(375, restaurant.calculateDiscount(customer));
        assertNotEquals(1500, restaurant.calculateDiscount(customer));
    }

    @Test
    void payBill_Successfully()
    {
        try
        {
            customer.addOrder(pizza);
            assertEquals(207, restaurant.payBill(customer));
            assertEquals(793, customer.getMoney());
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    void payBill_Fail()
    {
        customer.setMoney(9.99);
        customer.addOrder(pizza);
        assertThrows(FailedPayment.class, () -> restaurant.payBill(customer));
    }
}