package Restaurant;

import Restaurant.Consumable.Consumable;
import Restaurant.Consumable.Drink;
import Restaurant.Consumable.Pizza;
import Restaurant.Consumable.Side;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerTest
{
    public Customer customer;
    public Consumable pizza;
    public Consumable drink;
    public Consumable side;

    @BeforeEach
    void setUp()
    {
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
        this.pizza = new Pizza("Dalma", 11.99);
        this.side = new Side("Fries", 5);
        this.drink = new Drink("Cola", 2.5);
    }

    @Test
    void setFirstName()
    {
        this.customer.setFirstName("Keanu");
        assertEquals("Keanu", this.customer.getFirstName());
        assertNotEquals("Keanuu", this.customer.getFirstName());
    }

    @Test
    void setLastName()
    {
        this.customer.setLastName("Reeves");
        assertEquals("Reeves", this.customer.getLastName());
        assertNotEquals("Reves", this.customer.getLastName());
    }

    @Test
    void setEmail()
    {
        this.customer.setEmail("keanu.reeves.matrix@gmail.com");
        assertEquals("keanu.reeves.matrix@gmail.com", this.customer.getEmail());
        assertNotEquals("keanu.reeves@gmail.com", this.customer.getEmail());
    }

    @Test
    void setPhone()
    {
        this.customer.setPhone("+445720529818");
        assertEquals("+445720529818", this.customer.getPhone());
        assertNotEquals("+447520529818", this.customer.getPhone());
    }

    @Test
    void setAddress()
    {
        this.customer.setAddress("61 Grove Road");
        assertEquals("61 Grove Road", this.customer.getAddress());
        assertNotEquals("16 Grove Road", this.customer.getAddress());
    }

    @Test
    void setCity()
    {
        this.customer.setCity("Huddersfield");
        assertEquals("Huddersfield", this.customer.getCity());
        assertNotEquals("Hudders", this.customer.getCity());
    }

    @Test
    void setState()
    {
        this.customer.setState("United Kingdom");
        assertEquals("United Kingdom", this.customer.getState());
        assertNotEquals("UK", this.customer.getState());
    }

    @Test
    void setZip()
    {
        this.customer.setZip("HD201TK");
        assertEquals("HD201TK", this.customer.getZip());
        assertNotEquals("HD209LP", this.customer.getZip());
    }

    @Test
    void setOrder()
    {
        ArrayList<Consumable> newOrder = new ArrayList<>();
        customer.setOrder(newOrder);
        assertEquals(0, customer.getOrder().size());
        customer.addOrder(drink);
        assertEquals(1, customer.getOrder().size());
    }

    @Test
    void addOrder()
    {
        assertEquals(0, customer.getOrder().size());
        customer.addOrder(drink);
        customer.addOrder(pizza);
        customer.addOrder(side);
        assertEquals(3, customer.getOrder().size());
    }

    @Test
    void calculateTotalPrice()
    {
        assertEquals(0.0, customer.calculateTotalPrice());
        customer.addOrder(drink);
        customer.addOrder(pizza);
        customer.addOrder(side);
        assertEquals(19.490000000000002, customer.calculateTotalPrice());
    }

    @Test
    void setMoney()
    {
        assertEquals(1000.0, customer.getMoney());
        assertEquals(0.0, customer.calculateTotalPrice());
        customer.addOrder(drink);
        customer.addOrder(pizza);
        customer.addOrder(side);
        assertEquals(19.490000000000002, customer.calculateTotalPrice());
    }
}