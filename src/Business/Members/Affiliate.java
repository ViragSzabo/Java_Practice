package Business.Members;

import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;

public class Affiliate extends Member
{
    private double fixedEarnings;

    public Affiliate(String name)
    {
        super(name);
        this.fixedEarnings = 150;
        this.level = Levels.BRONZE;
    }

    @Override
    public double calculateEarnings() throws CALCULATE_EARNINGS_WITHOUT_SALE
    {
        return fixedEarnings;
    }
}