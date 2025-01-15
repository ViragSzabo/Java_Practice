package Platform;

public class Customer
{
    private String name;
    private String email;
    private Cart cart;

    public Customer(String name, String email)
    {
        this.cart = new Cart();
        this.name = name;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Cart getCart()
    {
        return cart;
    }

    public void cleanCart()
    {
        new Cart();
    }

    public void addCart(Product product)
    {
        this.cart.addItem(product);
    }
}