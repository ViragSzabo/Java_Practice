package Restaurant;

public class PizzaRestaurant
{
    private String name;
    private final double GENERAL_TIP;
    private final double DISCOUNT_100;
    private final double DISCOUNT_200;

    public PizzaRestaurant(String name)
    {
        this.name = name;
        this.GENERAL_TIP = 0.15;
        this.DISCOUNT_100 = 0.10;
        this.DISCOUNT_200 = 0.20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateDiscount(Customer customer)
    {
        double total = customer.calculateTotalPrice();
        if(total >= 200)
        {
            return total - (total * DISCOUNT_200);
        } else if (total >= 100)
        {
            return total - (total * DISCOUNT_100);
        }
        return total;
    }

    public double payBill(Customer customer) throws FailedPayment
    {
        double pay = calculateDiscount(customer) + (calculateDiscount(customer) * GENERAL_TIP);
        if(customer.getMoney() > pay)
        {
            customer.setMoney(customer.getMoney() - pay);
            return pay;
        } else
        {
            throw new FailedPayment("Not enough money to pay the bill.");
        }
    }
}