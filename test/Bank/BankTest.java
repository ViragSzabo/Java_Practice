package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest
{
    private Bank bank;
    private Customer customer;
    private Account account;
    private Account other;

    @BeforeEach
    void setUp()
    {
        this.bank = new Bank("MonkeyFinance");
        this.customer = new Customer("Tiffany");
        this.account = new Account("456");
        this.other = new Account("789");
        this.customer.addAccount(account);
        this.customer.addAccount(other);
    }

    @Test
    void getName()
    {
        assertEquals("MonkeyFinance", bank.getName());
        assertNotEquals("Monkey", bank.getName());
    }

    @Test
    void registerCustomer()
    {
        bank.registerCustomer(customer);
        assertEquals(1, bank.getCustomers().size());
        assertNotEquals(0, bank.getCustomers().size());
    }

    @Test
    void cancelCustomer()
    {
        bank.cancelCustomer(customer);
        assertEquals(0, bank.getCustomers().size());
        assertNotEquals(1, bank.getCustomers().size());
    }

    @Test
    void findCustomer()
    {
        bank.registerCustomer(customer);
        bank.findCustomer("Tiffany");
        assertEquals("Tiffany", bank.getCustomers().get(0).getName());
        assertThrows(IllegalArgumentException.class, () -> bank.findCustomer("Bill"));
    }

    @Test
    void getTotalDeposits()
    {
        bank.registerCustomer(customer);
        customer.getAccounts().get(0).setBalance(2500);
        customer.getAccounts().get(1).setBalance(2500);
        assertEquals(5000, bank.getTotalDeposits());
    }
}