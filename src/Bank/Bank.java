package Bank;

import java.util.*;

public class Bank
{
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String bankName)
    {
        this.name = bankName;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void registerCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public void cancelCustomer(Customer customer)
    {
        customers.remove(customer);
    }

    public void findCustomer(String name)
    {
        for(Customer customer : customers)
        {
            if(customer.getName().equals(name))
            {
                System.out.println(customer + " is found");
            }
            else
            {
                throw new IllegalArgumentException("Customer does not registered");
            }
        }
    }

    public double getTotalDeposits()
    {
        double total = 0.0;
        for(Customer customer : customers)
        {
            total += customer.getTotalBalance();
        }
        return total;
    }
}