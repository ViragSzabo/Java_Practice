package Business.Members;

import Business.Exceptions.ADD_EXISTED_MEMBER;
import Business.Exceptions.CALCULATE_EARNINGS_WITHOUT_SALE;
import Business.Exceptions.REMOVE_NOT_EXISTED_MEMBER;
import Business.Interfaces.MarketingOperations;

import java.util.*;

public abstract class Member implements MarketingOperations
{
    protected String name;
    protected Levels level;
    protected List<Member> members;

    public Member(String name)
    {
        this.name = name;
        this.level = Levels.STARTUP;
        this.members = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Levels getLevel()
    {
        return level;
    }

    public void setLevel(Levels level)
    {
        this.level = level;
    }

    public List<Member> getMembers()
    {
        return members;
    }

    @Override
    public void addMembers(Member member) throws ADD_EXISTED_MEMBER
    {
        if(members.contains(member))
        {
            throw new ADD_EXISTED_MEMBER();
        } else {
            members.add(member);
        }
    }

    @Override
    public void removeMembers(Member member) throws REMOVE_NOT_EXISTED_MEMBER
    {
        if(!members.contains(member))
        {
            throw new REMOVE_NOT_EXISTED_MEMBER();
        } else {
            members.remove(member);
        }
    }

    @Override
    public void showDownlines()
    {
        System.out.println("Downlines of " + this.name + ": ");
        for(Member member : members)
        {
            System.out.println("- " + member.getName() + "(" + member.getLevel() + ")");
        }
    }

    @Override
    public double calculateTotalEarnings() throws CALCULATE_EARNINGS_WITHOUT_SALE {
        double totalEarnings = 0;
        for(Member member : members)
        {
            totalEarnings += member.calculateEarnings();
        }
        return totalEarnings;
    }

    public abstract double calculateEarnings() throws CALCULATE_EARNINGS_WITHOUT_SALE;
}