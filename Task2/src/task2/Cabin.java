package task2;

import java.util.ArrayList;

/**
 * Abstract parent class representing a Cabin on a Ship.
 * 
 * A Cabin:
 * - Has a unique cabin number
 * - Belongs to exactly one Ship
 * - Can contain multiple Passengers
 * 
 * This class is ABSTRACT because, according to Figure 2
 * in the coursework brief, cabins are specialised into:
 * - Suite
 * - StandardCabin
 * 
 * Therefore, Cabin itself should never be instantiated directly.
 */
public abstract class Cabin {

    // Unique cabin number (set once and never changes)
    private final int number;

    // Reference to the Ship this cabin belongs to
    private Ship ship;

    // List of passengers currently residing in this cabin
    private final ArrayList<Passenger> passengers;

    /**
     * Constructs a Cabin with a given cabin number.
     * The passenger list is initialised as empty.
     *
     * @param number the cabin number
     */
    public Cabin(int number) {
        this.number = number;
        this.passengers = new ArrayList<>();
    }

    /**
     * Returns the cabin number.
     *
     * @return cabin number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the ship this cabin belongs to.
     *
     * @return ship reference
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Sets the ship that owns this cabin.
     * This method is called when the cabin is added to a ship.
     *
     * @param ship the owning ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Returns the list of passengers currently in this cabin.
     *
     * @return list of passengers
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Adds a passenger to this cabin and updates
     * the passenger's cabin reference accordingly.
     *
     * @param passenger the passenger to add
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setCabin(this);
    }

    /**
     * Returns a simple textual description of the cabin.
     * Subclasses may extend this if needed.
     *
     * @return cabin description
     */
    @Override
    public String toString() {
        return "Cabin " + number;
    }
}