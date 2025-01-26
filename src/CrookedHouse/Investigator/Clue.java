package CrookedHouse.Investigator;

public class Clue
{
    private String description;
    private String location;
    private Character implicates;

    public Clue(String description, String location, Character implicates)
    {
        this.description = description;
        this.location = location;
        this.implicates = implicates;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Character getImplicates()
    {
        return implicates;
    }

    public void setImplicates(Character implicates)
    {
        this.implicates = implicates;
    }

    public void examine()
    {
        System.out.println("Clue found in " + location + ": " + description);
        if (implicates != null) {
            System.out.println("This clue implicates: " + implicates);
        }
    }
}