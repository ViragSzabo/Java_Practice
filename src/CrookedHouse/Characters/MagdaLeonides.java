package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class MagdaLeonides extends Character
{
    /** Constructor */
    public MagdaLeonides(String name, int age)
    {
        super(name, age);
        this.setRelationship(RelationshipToVictim.DAUGHTER_IN_LAW);
    }

    @Override
    public void speak()
    {
        System.out.println("Blablabla");
    }
}