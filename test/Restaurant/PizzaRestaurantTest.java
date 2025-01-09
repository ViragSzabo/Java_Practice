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
        this.pizza = new Pizza("Dalma", 50.0);
        this.side = new Side("Fries", 10.0);
        this.drink = new Drink("Cola", 5.0);
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
    void getName() {
        assertEquals("Pottcast", restaurant.getName());
    }

    @Test
    void setName() {
        restaurant.setName("Pottcast Restaurant");
        assertEquals("Pottcast Restaurant", restaurant.getName());
    }

    @Test
    void calculateDiscount() {
        customer.addOrder(drink);
        assertEquals(5.0, restaurant.calculateDiscount(customer));
        customer.addOrder(side);
        assertEquals(15.0, restaurant.calculateDiscount(customer));
        customer.addOrder(pizza);
        assertEquals(65.0, restaurant.calculateDiscount(customer));
        customer.addOrder(pizza);
        assertNotEquals(115.0, restaurant.calculateDiscount(customer));
        assertEquals(103.5, restaurant.calculateDiscount(customer));
        customer.addOrder(pizza);
        customer.addOrder(pizza);
        assertNotEquals(215.0, restaurant.calculateDiscount(customer));
        assertEquals(172.0, restaurant.calculateDiscount(customer));
    }

    @Test
    void payBill_Successfully()
    {
        try
        {
            customer.addOrder(drink);
            customer.addOrder(pizza);
            customer.addOrder(side);
            assertEquals(74.75, restaurant.payBill(customer));
            assertEquals(925.25, customer.getMoney());
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