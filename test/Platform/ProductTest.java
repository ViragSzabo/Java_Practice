package Platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product("Smile", 14.50, Category.BEAUTY, 50);
    }

    @Test
    void setName() {
        assertEquals("Smile", product.getName());
        this.product.setName("Smile Wide");
        assertEquals("Smile Wide", product.getName());
    }

    @Test
    void setPrice() {
        assertEquals(14.50, product.getPrice());
        this.product.setPrice(22.50);
        assertEquals(22.50, product.getPrice());
    }

    @Test
    void setCategory() {
        assertEquals(Category.BEAUTY, product.getCategory());
        this.product.setCategory(Category.TOOTH);
        assertEquals(Category.TOOTH, product.getCategory());
    }

    @Test
    void setStock() {
        assertEquals(50, product.getStock());
        this.product.setStock(25);
        assertEquals(25, product.getStock());
    }
}