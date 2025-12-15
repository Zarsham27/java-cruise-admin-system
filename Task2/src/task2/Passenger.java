package task2;

import java.util.ArrayList;

/**
 * Represents a Passenger taking part in a Cruise.
 *
 * A Passenger:
 * - Has a name
 * - Is on exactly one Cruise
 * - Resides in one Cabin
 * - Can join multiple Excursions
 *
 * This class directly reflects the Passenger entity
 * shown in Figure 2 of the Task 2 coursework brief.
 */
public class Passenger {

    // Name of the passenger (set once and never changes)
    private final String name;

    // Reference to the cruise this passenger is on
    private Cruise cruise;

    // Reference to the cabin the passenger is staying in
    private Cabin cabin;

    // List of excursions the passenger has joined
    private final ArrayList<Excursion> excursions;

    /**
     * Constructs a Passenger with a given name.
     * Cruise and cabin will be assigned later.
     *
     * @param name passenger name
     */
    public Passenger(String name) {
        this.name = name;
        this.excursions = new ArrayList<>();
    }

    /**
     * Returns the passenger's name.
     *
     * @return name of passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cruise this passenger is on.
     *
     * @return cruise reference
     */
    public Cruise getCruise() {
        return cruise;
    }

    /**
     * Sets the cruise for this passenger.
     * This method is called when the passenger
     * is added to a cruise.
     *
     * @param cruise the cruise to assign
     */
    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    /**
     * Returns the cabin the passenger is staying in.
     *
     * @return cabin reference
     */
    public Cabin getCabin() {
        return cabin;
    }

    /**
     * Assigns a cabin to this passenger.
     * This method is called when the passenger
     * is added to a cabin.
     *
     * @param cabin the assigned cabin
     */
    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    /**
     * Returns the list of excursions the passenger has joined.
     *
     * @return list of excursions
     */
    public ArrayList<Excursion> getExcursions() {
        return excursions;
    }

    /**
     * Adds the passenger to an excursion.
     * This method also updates the excursion
     * to include this passenger.
     *
     * @param excursion the excursion to join
     */
    public void joinExcursion(Excursion excursion) {
        excursions.add(excursion);
        excursion.addPassenger(this);
    }

    /**
     * Returns the passenger name as a string representation.
     *
     * @return passenger name
     */
    @Override
    public String toString() {
        return name;
    }
}