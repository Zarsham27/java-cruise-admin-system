package task2;

import java.util.ArrayList;

/**
 * Represents a Cruise.
 * 
 * A Cruise:
 * - Uses exactly one Ship
 * - Has many Passengers on board
 * - Offers multiple Excursions
 * 
 * This class acts as the central object in the system,
 * linking ships, passengers, and excursions together,
 * exactly as shown in Figure 2 of the coursework brief.
 */
public class Cruise {

    // The ship used for this cruise
    private final Ship ship;

    // List of passengers currently on the cruise
    private final ArrayList<Passenger> passengers;

    // List of excursions offered on this cruise
    private final ArrayList<Excursion> excursions;

    /**
     * Constructs a Cruise using the given ship.
     * Passenger and excursion lists start empty.
     *
     * @param ship the ship used for this cruise
     */
    public Cruise(Ship ship) {
        this.ship = ship;
        this.passengers = new ArrayList<>();
        this.excursions = new ArrayList<>();
    }

    /**
     * Returns the ship used by this cruise.
     *
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Returns the list of passengers on the cruise.
     *
     * @return list of passengers
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Returns the list of excursions offered on the cruise.
     *
     * @return list of excursions
     */
    public ArrayList<Excursion> getExcursions() {
        return excursions;
    }

    /**
     * Adds a passenger to the cruise and
     * updates the passenger's cruise reference.
     *
     * @param passenger the passenger to add
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setCruise(this);
    }

    /**
     * Adds an excursion to the cruise.
     *
     * @param excursion the excursion to add
     */
    public void addExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    /**
     * Returns a simple textual description of the cruise.
     *
     * @return cruise description
     */
    @Override
    public String toString() {
        return "Cruise on ship " + ship.getName();
    }
}