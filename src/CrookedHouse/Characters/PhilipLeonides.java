package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class PhilipLeonides extends Character
{
    /**  Constructor */
    public PhilipLeonides(String name, int age)
    {
        super(name, age);
        this.setRelationship(RelationshipToVictim.CHILD);
    }

    @Override
    public void speak()
    {
        System.out.println("Blablabla");
    }
}
