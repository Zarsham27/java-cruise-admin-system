package task2;

import java.util.ArrayList;

/**
 * Represents a Ship used for a Cruise.
 *
 * A Ship:
 * - Has a name
 * - Contains multiple Cabins
 *
 * According to Figure 2 of the Task 2 coursework brief,
 * a Ship aggregates Cabin objects and assigns ownership
 * of cabins when they are added.
 */
public class Ship {

    // Name of the ship (set once and never changes)
    private final String name;

    // List of cabins contained on the ship
    private final ArrayList<Cabin> cabins;

    /**
     * Constructs a Ship with the given name.
     * The cabin list starts empty.
     *
     * @param name the ship name
     */
    public Ship(String name) {
        this.name = name;
        this.cabins = new ArrayList<>();
    }

    /**
     * Returns the ship's name.
     *
     * @return ship name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of cabins on the ship.
     *
     * @return list of cabins
     */
    public ArrayList<Cabin> getCabins() {
        return cabins;
    }

    /**
     * Adds a cabin to the ship and assigns
     * this ship as the cabin's owner.
     *
     * @param cabin the cabin to add
     */
    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
        cabin.setShip(this);
    }

    /**
     * Returns the ship name as a string representation.
     *
     * @return ship name
     */
    @Override
    public String toString() {
        return name;
    }
}