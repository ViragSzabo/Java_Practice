package Platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;
    private Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product("Smile", 14.50, Category.BEAUTY, 50);
        this.cart = new Cart();
    }

    @Test
    void addItem() {
        assertEquals(0, this.cart.getItems().size());
        this.cart.addItem(product);
        assertEquals(1, this.cart.getItems().size());
    }

    @Test
    void removeItem() {
        this.cart.addItem(product);
        assertEquals(1, this.cart.getItems().size());
        this.cart.removeItem(product);
        assertEquals(0, this.cart.getItems().size());
    }

    @Test
    void getTotalPrice() {
        this.cart.addItem(product);
        assertEquals(14.50, this.cart.getTotalPrice());
    }
}