package Brooklyn99.Station;

public class Case
{
    private int caseID;
    private String details;
    private boolean isSolved;

    public Case(int caseID, String details)
    {
        this.caseID = caseID;
        this.details = details;
        this.isSolved = false;
    }

    public int getCaseID()
    {
        return caseID;
    }

    public void setCaseID(int caseID)
    {
        this.caseID = caseID;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public boolean isSolved()
    {
        return isSolved;
    }

    public void setSolved(boolean solved)
    {
        isSolved = solved;
    }

    public void markAsSolved()
    {
        setSolved(true);
    }

    public void getCaseInfo()
    {
        System.out.println("--------------------");
        System.out.println("Case ID: " + caseID);
        System.out.println("Details: " + details);
        System.out.println("Solved: " + isSolved);
        System.out.println("--------------------");
    }
}