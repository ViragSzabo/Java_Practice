package Restaurant;

import Restaurant.Consumable.Consumable;
import Restaurant.Consumable.Drink;
import Restaurant.Consumable.Pizza;
import Restaurant.Consumable.Side;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerTest
{
    public Customer customer;
    public Consumable pizza;
    public Consumable drink;
    public Consumable side;

    @org.junit.jupiter.api.BeforeEach
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

    @org.junit.jupiter.api.Test
    void getFirstName()
    {
        assertEquals("Keanuu", this.customer.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setFirstName()
    {
        this.customer.setFirstName("Keanu");
        assertEquals("Keanu", this.customer.getFirstName());
        assertNotEquals("Keanuu", this.customer.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName()
    {
        assertEquals("Reves", this.customer.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setLastName()
    {
        this.customer.setLastName("Reeves");
        assertEquals("Reeves", this.customer.getLastName());
        assertNotEquals("Reves", this.customer.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getEmail()
    {
        assertEquals("keanu.reeves@gmail.com", this.customer.getEmail());
    }

    @org.junit.jupiter.api.Test
    void setEmail()
    {
        this.customer.setEmail("keanu.reeves.matrix@gmail.com");
        assertEquals("keanu.reeves.matrix@gmail.com", this.customer.getEmail());
        assertNotEquals("keanu.reeves@gmail.com", this.customer.getEmail());
    }

    @org.junit.jupiter.api.Test
    void getPhone()
    {
        assertEquals("+447520529818", this.customer.getPhone());
    }

    @org.junit.jupiter.api.Test
    void setPhone()
    {
        this.customer.setPhone("+445720529818");
        assertEquals("+445720529818", this.customer.getPhone());
        assertNotEquals("+447520529818", this.customer.getPhone());
    }

    @org.junit.jupiter.api.Test
    void getAddress()
    {
        assertEquals("16 Grove Road", this.customer.getAddress());
    }

    @org.junit.jupiter.api.Test
    void setAddress()
    {
        this.customer.setAddress("61 Grove Road");
        assertEquals("61 Grove Road", this.customer.getAddress());
        assertNotEquals("16 Grove Road", this.customer.getAddress());
    }

    @org.junit.jupiter.api.Test
    void getCity()
    {
        assertEquals("Hudders", this.customer.getCity());
    }

    @org.junit.jupiter.api.Test
    void setCity()
    {
        this.customer.setCity("Huddersfield");
        assertEquals("Huddersfield", this.customer.getCity());
        assertNotEquals("Hudders", this.customer.getCity());
    }

    @org.junit.jupiter.api.Test
    void getState()
    {
        assertEquals("UK", this.customer.getState());
    }

    @org.junit.jupiter.api.Test
    void setState()
    {
        this.customer.setState("United Kingdom");
        assertEquals("United Kingdom", this.customer.getState());
        assertNotEquals("UK", this.customer.getState());
    }

    @org.junit.jupiter.api.Test
    void getZip()
    {
        assertEquals("HD209LP", this.customer.getZip());
    }

    @org.junit.jupiter.api.Test
    void setZip()
    {
        this.customer.setZip("HD201TK");
        assertEquals("HD201TK", this.customer.getZip());
        assertNotEquals("HD209LP", this.customer.getZip());
    }

    @org.junit.jupiter.api.Test
    void getOrder()
    {
        assertEquals(0, customer.getOrder().size());
        assertNotEquals(1, customer.getOrder().size());
    }

    @org.junit.jupiter.api.Test
    void setOrder()
    {
        ArrayList<Consumable> newOrder = new ArrayList<>();
        customer.setOrder(newOrder);
        assertEquals(0, customer.getOrder().size());
        customer.addOrder(drink);
        assertEquals(1, customer.getOrder().size());
    }

    @org.junit.jupiter.api.Test
    void addOrder()
    {
        assertEquals(0, customer.getOrder().size());
        customer.addOrder(drink);
        customer.addOrder(pizza);
        customer.addOrder(side);
        assertEquals(3, customer.getOrder().size());
    }

    @org.junit.jupiter.api.Test
    void calculateTotalPrice()
    {
        assertEquals(0.0, customer.calculateTotalPrice());
        customer.addOrder(drink);
        customer.addOrder(pizza);
        customer.addOrder(side);
        assertEquals(19.490000000000002, customer.calculateTotalPrice());
    }

    @org.junit.jupiter.api.Test
    void getMoney()
    {
        assertEquals(1000.0, customer.getMoney());
    }

    @org.junit.jupiter.api.Test
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