package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public class JosephineLeonides extends Character
{
    /** Constructor */
    public JosephineLeonides(String name, int age)
    {
        super(name, age);
        this.setRelationship(RelationshipToVictim.GRANDCHILD);
    }

    @Override
    public void speak()
    {
        System.out.println("Blablabla");
    }
}