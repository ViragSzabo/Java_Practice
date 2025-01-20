package Airline.Airlines;

import Airline.Exceptions.InvalidData;
import Airline.Flights.Flight;
import Airline.Passengers.Passenger;

import java.util.ArrayList;

public class Airline
{
    /** Parameters of Airline */
    private Types type;
    private final ArrayList<Flight> flights;

    /** Constructor of Airline */
    public Airline()
    {
        this.type = Types.NOT_SPECIFY;
        this.flights = new ArrayList<>();
    }

    /**
     * Get the type of the Airline
     * @return a string
     */
    public Types getType() {
        return type;
    }
    /** Change the type of the airline */
    public void setType(Types type) {
        this.type = type;
    }

    /**
     * Get the flights of the airline
     * @return a list
     */
    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    /** Add a new flight to the airline */
    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    /** Remove a flight from the airline */
    public void removeFlight(String flightNumber) throws InvalidData
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
            throw new InvalidData();
        }
    }

    /** Book a flight for a specific passenger */
    public void bookFlight(Passenger passenger, String flightNumber) throws InvalidData
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
                throw new InvalidData();
            }
        }
    }

    /** Cancel a booking for a specific passenger */
    public void cancelBooking(Passenger passenger, String flightNumber) throws InvalidData
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
            throw new InvalidData();
        }
    }
}