package Restaurant;

import Restaurant.Consumable.Consumable;

import java.util.ArrayList;

public class Customer
{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private ArrayList<Consumable> orderList;
    private double money;

    public Customer(String firstName, String lastName, String email, String phone,
                    String address, String city, String state, String zip, double money)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.orderList = new ArrayList<>();
        this.money = money;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public ArrayList<Consumable> getOrder()
    {
        return orderList;
    }

    public void setOrder(ArrayList<Consumable> order)
    {
        this.orderList = order;
    }

    public void addOrder(Consumable order)
    {
        this.orderList.add(order);
    }

    public double calculateTotalPrice()
    {
        return orderList.stream().mapToDouble(Consumable::getPrice).sum();
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }
}