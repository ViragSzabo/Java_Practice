package CrookedHouse.Characters;

import CrookedHouse.RelationshipToVictim;

public abstract class Character
{
    private String name;
    private int age;
    private RelationshipToVictim relationship;
    private String alibi;
    private boolean isMurderer;

    /** Constructor */
    public Character(String name, int age, RelationshipToVictim relationshipToVictim, String alibi, boolean isMurderer) {
        this.name = name;
        this.age = age;
        this.relationship = relationshipToVictim;
        this.alibi = alibi;
        this.isMurderer = isMurderer;
    }

    public Character(String name, int age) {
    }

    /** Getter and Setter Methods */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public RelationshipToVictim getRelationship()
    {
        return relationship;
    }

    public void setRelationship(RelationshipToVictim relationship)
    {
        this.relationship = relationship;
    }

    public String getAlibi()
    {
        return alibi;
    }

    public void setAlibi(String alibi)
    {
        this.alibi = alibi;
    }

    public boolean isMurderer()
    {
        return isMurderer;
    }

    public void setMurderer(boolean murderer)
    {
        isMurderer = murderer;
    }

    /** Each character has unique dialogue */
    public abstract void speak();
}