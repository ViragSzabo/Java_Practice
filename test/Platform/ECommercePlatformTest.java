package Platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ECommercePlatformTest {
    private ECommercePlatform platform;
    private Product product;
    private Customer customer;

    @BeforeEach
    void setUp()
    {
        this.platform = new ECommercePlatform("Get YourSelf");
        this.customer = new Customer("Viola", "viola.1997@hotmail.hu");
        this.product = new Product("Smile", 14.50, Category.BEAUTY, 50);
    }

    @Test
    void setName() {
        assertEquals("Get YourSelf", platform.getName());
        this.platform.setName("YourSelf");
        assertEquals("YourSelf", platform.getName());
    }

    @Test
    void removeProduct() {
        this.platform.addProduct(product);
        assertThrows(IllegalArgumentException.class, () -> this.platform.addProduct(product));
        assertEquals(1, this.platform.getProducts().size());
        this.platform.removeProduct(product);
        assertEquals(0, this.platform.getProducts().size());
        assertThrows(IllegalArgumentException.class, () -> this.platform.removeProduct(product));
    }

    @Test
    void registerCustomer() {
        this.platform.registerCustomer(customer);
        assertEquals(1, this.platform.getCustomers().size());
        assertThrows(IllegalArgumentException.class, () -> this.platform.registerCustomer(customer));
        this.platform.removeCustomer(customer);
        assertEquals(0, this.platform.getCustomers().size());
        assertThrows(IllegalArgumentException.class, () -> this.platform.removeCustomer(customer));
    }

    @Test
    void searchProduct() {
        this.platform.addProduct(product);
        this.platform.searchProduct("Smile");
        assertEquals("Smile", this.platform.getProducts().get(0).getName());
        assertThrows(IllegalArgumentException.class, () -> this.platform.searchProduct("King"));
    }

    @Test
    void checkout() {
        this.platform.addProduct(product);
        assertEquals(1, this.platform.getProducts().size());
        this.platform.registerCustomer(customer);
        assertEquals(1, this.platform.getCustomers().size());
        this.customer.addCart(product);
        assertEquals(1, this.customer.getCart().getItems().size());
        this.platform.checkout(customer);
        assertEquals(14.50, this.customer.getCart().getTotalPrice());
    }
}