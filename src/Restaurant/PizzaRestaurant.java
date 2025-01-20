package Restaurant;

public class PizzaRestaurant
{
    private String name;
    private final double GENERAL_TIP;
    protected Discounts discount;

    public PizzaRestaurant(String name)
    {
        this.name = name;
        this.GENERAL_TIP = 0.15;
        this.discount = Discounts.NO_DISCOUNT;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private double getDiscountRate(double total) {
        if (total >= 1500) return 0.75;
        if (total >= 750) return 0.50;
        if (total >= 250) return 0.25;
        if (total >= 100) return 0.10;
        return 0.0;
    }

    public double calculateDiscount(Customer customer)
    {
        double total = customer.calculateTotalPrice();
        double discountRate = getDiscountRate(total);

        if(discountRate == 0.75)
        {
            this.discount = Discounts.ABOVE_1500;
        }else if (discountRate >= 0.50)
        {
            this.discount = Discounts.ABOVE_750;
        } else if(discountRate >= 0.25)
        {
            this.discount = Discounts.ABOVE_250;
        }
        else if(discountRate >= 0.10)
        {
            this.discount = Discounts.ABOVE_100;
        }
        else
        {
            this.discount = Discounts.NO_DISCOUNT;
        }
        return total - (total * discountRate);
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
            throw new FailedPayment();
        }
    }
}