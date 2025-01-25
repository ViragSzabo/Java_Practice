package Brooklyn99.Station;

import Brooklyn99.Exceptions.CASE_NOT_FOUND;
import Brooklyn99.Roles.Detective;
import Brooklyn99.Roles.PolicePersonnel;

import java.util.ArrayList;
import java.util.HashMap;

public class PoliceStation
{
    private ArrayList<PolicePersonnel> people;
    private HashMap<Case, Detective> cases;

    public PoliceStation()
    {
        this.people = new ArrayList<>();
        this.cases = new HashMap<>();
    }

    public ArrayList<PolicePersonnel> getPeople()
    {
        return people;
    }

    public HashMap<Case, Detective> getCases()
    {
        return cases;
    }

    public void addNewPerson(PolicePersonnel person)
    {
        this.people.add(person);
    }

    public void removePerson(PolicePersonnel person)
    {
        this.people.remove(person);
    }

    public void removeCase(Case caseToRemove) throws CASE_NOT_FOUND
    {
        if(cases.containsKey(caseToRemove))
        {
            this.cases.remove(caseToRemove);
        } else
        {
            throw new CASE_NOT_FOUND();
        }
    }

    public void assignCaseToDetective(Case assignedCase, Detective detective)
    {
        this.cases.put(assignedCase, detective);
        showUnsolvedCases();
    }

    private void showUnsolvedCases()
    {
        for(Case currentCase : this.cases.keySet())
        {
            if(!currentCase.isSolved())
            {
                System.out.println("Unsolved Cases");
                System.out.println("-----------");
                System.out.println(currentCase);
            }
            else
            {
                System.out.println("Solved Cases");
            }
        }
    }
}