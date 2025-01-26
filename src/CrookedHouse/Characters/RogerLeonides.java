package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class RogerLeonides extends Character
{
    /** Constructor */
    public RogerLeonides(String name, int age)
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