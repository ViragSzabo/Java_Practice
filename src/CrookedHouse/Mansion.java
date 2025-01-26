package CrookedHouse;

import CrookedHouse.Investigator.Clue;
import CrookedHouse.Characters.Character;
import java.util.ArrayList;

public class Mansion
{
    private int rooms;
    private final ArrayList<Character> suspects;
    private final ArrayList<Clue> clues;

    public Mansion()
    {
        this.suspects = new ArrayList<>();
        this.clues = new ArrayList<>();
    }

    public int getRooms()
    {
        return rooms;
    }

    public void setRooms(int rooms)
    {
        this.rooms = rooms;
    }

    public ArrayList<Character> getSuspects() {
        return suspects;
    }

    public ArrayList<Clue> getClues() {
        return clues;
    }

    public void addSuspect(Character suspect) {
        suspects.add(suspect);
    }

    public void addClue(Clue clue) {
        clues.add(clue);
    }

    public void searchRoom(Rooms room)
    {
        System.out.println("Searching for " + room);
        for (Clue clue : clues)
        {
            clue.examine();
        }
    }

    public void listOfSuspects()
    {
        System.out.println("Suspects in the mansion:");
        for (Character suspect : suspects) {
            System.out.println("- " + suspect.getName());
        }
    }

    public void accuse(Character suspect)
    {
        if (suspect.isMurderer())
        {
            System.out.println("You accused " + suspect.getName() + " correctly! They are the murderer!");
        } else {
            System.out.println("You accused " + suspect.getName() + " incorrectly. The real murderer remains free.");
        }
    }
}