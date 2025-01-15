package Platform;

import java.util.*;

public class ECommercePlatform
{
    private String name;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;

    public ECommercePlatform(String name)
    {
        this.name = name;
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product)
    {
        if(!this.products.contains(product))
        {
            this.products.add(product);
        }
        else
        {
            throw new IllegalArgumentException("Product already exists");
        }
    }

    public void removeProduct(Product product)
    {
        if(this.products.contains(product))
        {
            this.products.remove(product);
        }
        else
        {
            throw new IllegalArgumentException("Product does not exist");
        }
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void registerCustomer(Customer customer)
    {
        if(!this.customers.contains(customer))
        {
            this.customers.add(customer);
        }
        else {
            throw new IllegalArgumentException("Customer already registered");
        }
    }

    public void removeCustomer(Customer customer)
    {
        if(this.customers.contains(customer))
        {
            this.customers.remove(customer);
        }
        else
        {
            throw new IllegalArgumentException("Customer not registered");
        }
    }

    public void searchProduct(String keyword)
    {
        ArrayList<Product> keywordProducts = new ArrayList<>();
        for(Product product : this.products)
        {
            if(product.getName().contains(keyword))
            {
                keywordProducts.add(product);
            }
            else {
                throw new IllegalArgumentException("Product does not found");
            }
        }

        for(Product product : keywordProducts)
        {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }

    public void checkout(Customer customer)
    {
        for(Product product : customer.getCart().getItems())
        {
            product.setStock(customer.getCart().getItems().size());
        }
        System.out.println("€" + customer.getCart().getTotalPrice() + " paid.");
        customer.cleanCart();
    }
}