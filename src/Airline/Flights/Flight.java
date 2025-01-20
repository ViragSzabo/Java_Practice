package Airline.Flights;

import Airline.Passengers.Passenger;

import java.util.ArrayList;

public class Flight
{
    private String flightNumber;
    private String destination;
    private final int CAPACITY = 50;
    private final ArrayList<Passenger> passengers;

    public Flight(String flightNumber, String destination)
    {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassengers()
    {
        return passengers;
    }

    public void removePassenger(Passenger passenger)
    {
        if(!passengers.contains(passenger))
        {
            throw new IllegalArgumentException("Passenger not found!");
        }
        passengers.remove(passenger);
    }

    public void addPassenger(Passenger passenger)
    {
        if(passengers.size() >= CAPACITY)
        {
            throw new IllegalArgumentException("No more places available!");
        } else
        {
            passengers.add(passenger);
        }
    }
}