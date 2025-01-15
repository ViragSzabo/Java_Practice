package Platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest
{
    private Product product;
    private Customer customer;

    @BeforeEach
    void setUp()
    {
        this.customer = new Customer("Viola", "viola.1997@hotmail.hu");
        this.product = new Product("Smile", 14.50, Category.BEAUTY, 50);
    }

    @Test
    void setName()
    {
        assertEquals("Viola", customer.getName());
        customer.setName("Viola D");
        assertEquals("Viola D", customer.getName());
    }

    @Test
    void setEmail()
    {
        assertEquals("viola.1997@hotmail.hu", customer.getEmail());
        customer.setEmail("viola.1997@gmail.com");
        assertEquals("viola.1997@gmail.com", customer.getEmail());
    }

    @Test
    void cleanCart()
    {
        assertEquals(0, customer.getCart().getItems().size());
        customer.addCart(product);
        assertEquals(1, customer.getCart().getItems().size());
        assertEquals(14.50, customer.getCart().getTotalPrice());
    }
}