package Airline;

import java.util.ArrayList;

public class Airline
{
    private String name;
    private final ArrayList<Flight> flights;

    public Airline(String name)
    {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    public void removeFlight(String flightNumber)
    {
        boolean flightFound = false;
        for(Flight flight : flights)
        {
            if(flight.getFlightNumber().equals(flightNumber))
            {
                flights.remove(flight);
                System.out.println("Successful removing!");
                flightFound = true;
                break;
            }
        }
        if (!flightFound)
        {
            throw new IllegalArgumentException("Invalid flight number!");
        }
    }

    public void bookFlight(Passenger passenger, String flightNumber)
    {
        for(Flight flight : flights)
        {
            if(flight.getFlightNumber().equals(flightNumber))
            {
                flight.addPassenger(passenger);
                System.out.println("Successful booking!");
            }
            else
            {
                throw new IllegalArgumentException("Invalid flight number");
            }
        }
    }

    public void cancelBooking(Passenger passenger, String flightNumber)
    {
        boolean flightFound = false;
        for(Flight flight : flights)
        {
            if(flight.getFlightNumber().equals(flightNumber))
            {
                flight.removePassenger(passenger);
                System.out.println("Successful cancelling!");
                flightFound = true;
                break;
            }
        }
        if (!flightFound)
        {
            throw new IllegalArgumentException("Invalid flight number!");
        }
    }
}