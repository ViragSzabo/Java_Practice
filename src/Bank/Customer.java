package Bank;

import java.util.*;

public class Customer
{
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name)
    {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }

    public double getTotalBalance()
    {
        double total = 0.0;
        for(Account account : accounts)
        {
            total += account.getBalance();
        }
        return total;
    }
}