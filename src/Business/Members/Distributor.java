package Business.Members;

import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;

public class Distributor extends Member
{
    private double sales;

    public Distributor(String name)
    {
        super(name);
        this.sales = 0.0;
    }

    public double getSales()
    {
        return this.sales;
    }

    public void addSales(double amount)
    {
        this.sales += amount;
    }

    @Override
    public double calculateEarnings() throws CALCULATE_EARNINGS_WITHOUT_SALE
    {
        double earnings = 0.0;
        if(sales <= 0)
        {
            throw new CALCULATE_EARNINGS_WITHOUT_SALE();
        }
        for(Member partner : this.getMembers())
        {
            if(partner instanceof Distributor distributor)
            {
                earnings += (distributor.calculateEarnings() * 0.10);
            }
        }
        return earnings + (sales * level.getCommisionRate());
    }
}