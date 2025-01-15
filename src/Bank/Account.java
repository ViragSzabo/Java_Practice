package Bank;

public class Account
{
    private String accountNumber;
    private double balance;

    public Account(String accountNumber)
    {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        setBalance(this.balance += amount);
    }

    public void withdraw(double amount)
    {
        if(amount < balance)
        {
            setBalance(this.balance -= amount);
        }
        else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void transfer(Account recipient, double amount)
    {
        recipient.deposit(amount);
        this.withdraw(amount);
    }
}