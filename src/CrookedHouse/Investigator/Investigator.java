package CrookedHouse.Investigator;

import java.util.ArrayList;
import CrookedHouse.Characters.Character;

public class Investigator
{
    private String name;
    private ArrayList<String> notes;

    public Investigator(String name)
    {
        this.name = name;
        this.notes = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getNotes()
    {
        return notes;
    }

    public void addNote(String newNote)
    {
        this.notes.add(newNote);
    }

    public void removeNote(String oldNote)
    {
        this.notes.add(oldNote);
    }

    public void interrogate(Character suspect)
    {
        System.out.println("Interrogating " + suspect.getName() + "...");
        suspect.speak();
        notes.add("Interrogated " + suspect.getName() + ": " + suspect.getName() + "'s alibi is suspicious.");
    }

    public void analyzeClues()
    {
        System.out.println("Reviewing notes:");
        for (String note : notes) {
            System.out.println("- " + note);
        }
    }
}