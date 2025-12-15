package task2;

/**
 * Represents a Suite cabin.
 *
 * A Suite:
 * - Is a specialised type of Cabin
 * - May have a balcony
 *
 * This class extends the abstract Cabin class,
 * as shown in Figure 2 of the Task 2 coursework brief.
 */
public class Suite extends Cabin {

    // Indicates whether the suite has a balcony
    private final boolean hasBalcony;

    /**
     * Constructs a Suite with a given cabin number
     * and balcony availability.
     *
     * @param number the cabin number
     * @param hasBalcony true if the suite has a balcony
     */
    public Suite(int number, boolean hasBalcony) {
        super(number);
        this.hasBalcony = hasBalcony;
    }

    /**
     * Returns whether this suite has a balcony.
     *
     * @return true if balcony is present
     */
    public boolean hasBalcony() {
        return hasBalcony;
    }

    /**
     * Returns a textual description of the suite.
     *
     * @return suite description
     */
    @Override
    public String toString() {
        return super.toString() + " (Suite, Balcony: " + hasBalcony + ")";
    }
}