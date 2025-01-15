package Platform;

import java.util.ArrayList;

public class Cart
{
    private ArrayList<Product> items;

    public Cart()
    {
        this.items = new ArrayList<>();
    }

    public ArrayList<Product> getItems()
    {
        return items;
    }

    public void addItem(Product product)
    {
        this.items.add(product);
    }

    public void removeItem(Product product)
    {
        this.items.remove(product);
    }

    public double getTotalPrice()
    {
        double total = 0;
        for(Product item : items)
        {
            total += item.getPrice();
        }
        return total;
    }
}