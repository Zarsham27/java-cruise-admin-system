package task2;

import java.util.ArrayList;

/**
 * Represents an Excursion offered during a Cruise.
 * 
 * An Excursion:
 * - Takes place on a specific day of the week
 * - Goes to exactly one Port
 * - Can be joined by multiple Passengers
 * 
 * This class matches the Excursion entity shown in
 * Figure 2 of the coursework brief.
 */
public class Excursion {

    // Day on which the excursion takes place (e.g. Monday)
    private final String dayOfWeek;

    // Destination port of this excursion
    private final Port port;

    // List of passengers who have joined this excursion
    private final ArrayList<Passenger> passengers;

    /**
     * Constructs an Excursion with a day and destination port.
     * Passenger list starts empty.
     *
     * @param dayOfWeek the day the excursion occurs
     * @param port the destination port
     */
    public Excursion(String dayOfWeek, Port port) {
        this.dayOfWeek = dayOfWeek;
        this.port = port;
        this.passengers = new ArrayList<>();
    }

    /**
     * Returns the day of the week for this excursion.
     *
     * @return day of week
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Returns the destination port of this excursion.
     *
     * @return destination port
     */
    public Port getPort() {
        return port;
    }

    /**
     * Returns the list of passengers who joined this excursion.
     *
     * @return list of passengers
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Adds a passenger to this excursion.
     * This method is called when a passenger joins an excursion.
     *
     * @param passenger the passenger joining the excursion
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Returns a readable description of the excursion.
     *
     * @return excursion description
     */
    @Override
    public String toString() {
        return dayOfWeek + " – " + port.getName();
    }
}