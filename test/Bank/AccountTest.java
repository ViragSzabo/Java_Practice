package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    private Account recipent;

    @BeforeEach
    void setUp() {
        this.account = new Account("456");
        this.recipent = new Account("789");
    }

    @Test
    void setAccountNumber() {
        assertEquals("456", account.getAccountNumber());
        account.setAccountNumber("789");
        assertEquals("789", account.getAccountNumber());
        assertNotEquals("456", account.getAccountNumber());
    }

    @Test
    void setBalance() {
        assertEquals(0, account.getBalance());
        account.setBalance(100);
        assertEquals(100, account.getBalance());
        assertNotEquals(0, account.getBalance());
    }

    @Test
    void deposit() {
        account.deposit(150);
        assertEquals(150, account.getBalance());
        assertNotEquals(0, account.getBalance());
    }

    @Test
    void withdraw() {
        account.deposit(150);
        account.withdraw(50);
        assertEquals(100, account.getBalance());
        assertNotEquals(150, account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000));
    }

    @Test
    void transfer() {
        account.deposit(150);
        account.transfer(recipent, 25);
        assertEquals(25, recipent.getBalance());
        assertNotEquals(0, recipent.getBalance());
        assertEquals(125, account.getBalance());
        assertNotEquals(150, account.getBalance());
    }
}