package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class BrendaLeonides extends Character
{
    /** Constructor */
    public BrendaLeonides(String name, int age)
    {
        super(name, age);
        this.setRelationship(RelationshipToVictim.WIFE);
    }

    @Override
    public void speak()
    {
        System.out.println("Blablabla");
    }
}