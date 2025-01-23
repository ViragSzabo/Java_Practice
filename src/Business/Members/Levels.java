package Business.Members;

public enum Levels
{
    STARTUP(0.0),
    BRONZE(0.05),
    SILVER(0.10),
    GOLD(0.15),
    PLATINUM(0.20);

    private final double commisionRate;

    Levels(double commisionRate)
    {
        this.commisionRate = commisionRate;
    }

    public double getCommisionRate()
    {
        return commisionRate;
    }
}