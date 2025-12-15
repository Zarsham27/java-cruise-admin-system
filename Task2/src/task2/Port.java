package task2;

/**
 * Represents a Port destination for an Excursion.
 *
 * A Port:
 * - Has a name
 * - Acts as the destination of an Excursion
 *
 * According to Figure 2 of the Task 2 coursework brief,
 * a Port is a simple entity and does not manage
 * any collections or additional data.
 */
public class Port {

    // Name of the port (set once and never changes)
    private final String name;

    /**
     * Constructs a Port with the given name.
     *
     * @param name the name of the port
     */
    public Port(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the port.
     *
     * @return port name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the port name as a string representation.
     *
     * @return port name
     */
    @Override
    public String toString() {
        return name;
    }
}