package task2;

/**
 * Represents a Standard Cabin.
 *
 * A StandardCabin:
 * - Is a specialised type of Cabin
 * - May have a sea view
 *
 * This class extends the abstract Cabin class,
 * as shown in Figure 2 of the Task 2 coursework brief.
 */
public class StandardCabin extends Cabin {

    // Indicates whether the cabin has a sea view
    private final boolean hasSeaView;

    /**
     * Constructs a StandardCabin with a given
     * cabin number and sea view availability.
     *
     * @param number the cabin number
     * @param hasSeaView true if the cabin has a sea view
     */
    public StandardCabin(int number, boolean hasSeaView) {
        super(number);
        this.hasSeaView = hasSeaView;
    }

    /**
     * Returns whether this cabin has a sea view.
     *
     * @return true if sea view is present
     */
    public boolean hasSeaView() {
        return hasSeaView;
    }

    /**
     * Returns a textual description of the standard cabin.
     *
     * @return standard cabin description
     */
    @Override
    public String toString() {
        return super.toString() + " (Standard cabin, Sea view: " + hasSeaView + ")";
    }
}