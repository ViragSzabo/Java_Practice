package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class FirstSonLeonides extends Character
{
    /** Constructor */
    public FirstSonLeonides(String name, int age)
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