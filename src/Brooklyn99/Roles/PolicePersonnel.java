package Brooklyn99.Roles;

import Brooklyn99.Enums.*;

public abstract class PolicePersonnel
{
    private String name;
    private int badgeNumber;
    private Ranks rank;

    public PolicePersonnel(String name, int badgeNumber, Ranks rank)
    {
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getBadgeNumber()
    {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber)
    {
        this.badgeNumber = badgeNumber;
    }

    public Ranks getRank()
    {
        return rank;
    }

    public void setRank(Ranks rank)
    {
        this.rank = rank;
    }
}