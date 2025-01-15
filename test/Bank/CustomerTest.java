package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;
    private Account account;
    private Account other;

    @BeforeEach
    void setUp() {
        this.customer = new Customer("Tiffany");
        this.account = new Account("456");
        this.other = new Account("789");
        this.customer.addAccount(account);
    }

    @Test
    void setName() {
        assertEquals("Tiffany", customer.getName());
        customer.setName("Tiff");
        assertEquals("Tiff", customer.getName());
    }

    @Test
    void removeAccount() {
        assertEquals(1, customer.getAccounts().size());
        customer.addAccount(other);
        assertNotEquals(1, customer.getAccounts().size());
        assertEquals(2, customer.getAccounts().size());
        customer.removeAccount(other);
        customer.removeAccount(account);
        assertEquals(0, customer.getAccounts().size());
        assertNotEquals(2, customer.getAccounts().size());
    }

    @Test
    void getTotalBalance() {
        assertEquals(0, customer.getTotalBalance());
        customer.getAccounts().get(0).setBalance(100);
        customer.addAccount(other);
        customer.getAccounts().get(1).setBalance(50);
        assertEquals(150, customer.getTotalBalance());
    }
}