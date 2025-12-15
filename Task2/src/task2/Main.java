package task2;

import java.util.Scanner;

/**
 * Main class for Task 2 – Cruise System.
 *
 * This class:
 * - Acts as the entry point of the application
 * - Pre loads all required data in memory (no files / no database)
 * - Displays the menu
 * - Handles user input
 * - Calls methods on domain objects (Cruise, Passenger, etc.)
 *
 * IMPORTANT:
 * Business logic is NOT implemented here.
 * This class only coordinates user interaction.
 */
public class Main {

    /**
     * Program entry point.
     * Preloads data and starts the menu loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Cruise cruise = preloadData();
        menu(cruise);
    }

    // --------------------------------------------------
    // PRELOAD DATA (REQUIRED BY TASK 2 BRIEF)
    // --------------------------------------------------

    /**
     * Creates and links all objects required for the system.
     * Data is fully preloaded in code, as required by the coursework.
     *
     * @return a fully initialised Cruise object
     */
    private static Cruise preloadData() {

        // Create ship
        Ship ship = new Ship("Oceanic Explorer");

        // Create cabins and add them to the ship
        Suite suite1 = new Suite(101, true);
        Suite suite2 = new Suite(102, false);
        StandardCabin cabin1 = new StandardCabin(201, true);
        StandardCabin cabin2 = new StandardCabin(202, false);

        ship.addCabin(suite1);
        ship.addCabin(suite2);
        ship.addCabin(cabin1);
        ship.addCabin(cabin2);

        // Create cruise using the ship
        Cruise cruise = new Cruise(ship);

        // Create ports
        Port barcelona = new Port("Barcelona");
        Port naples = new Port("Naples");
        Port marseille = new Port("Marseille");

        // Create excursions and add them to the cruise
        Excursion ex1 = new Excursion("Monday", barcelona);
        Excursion ex2 = new Excursion("Wednesday", naples);
        Excursion ex3 = new Excursion("Friday", marseille);

        cruise.addExcursion(ex1);
        cruise.addExcursion(ex2);
        cruise.addExcursion(ex3);

        // Create passengers
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");

        // Add passengers to the cruise
        cruise.addPassenger(p1);
        cruise.addPassenger(p2);
        cruise.addPassenger(p3);

        // Assign cabins to passengers
        suite1.addPassenger(p1);
        cabin1.addPassenger(p2);
        cabin2.addPassenger(p3);

        // Passengers join excursions
        p1.joinExcursion(ex1);
        p2.joinExcursion(ex2);
        p3.joinExcursion(ex1);
        p3.joinExcursion(ex3);

        return cruise;
    }

    // --------------------------------------------------
    // MENU
    // --------------------------------------------------

    /**
     * Displays the main menu and processes user choices.
     * The menu loops until the user chooses to exit.
     *
     * @param cruise the active cruise object
     */
    private static void menu(Cruise cruise) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------------------------");
            System.out.println(" Cruise Menu");
            System.out.println("------------------------");
            System.out.println("1. List passengers");
            System.out.println("2. Assign cabin to passenger");
            System.out.println("3. Join excursion");
            System.out.println("4. List excursions");
            System.out.println("0. Exit");
            System.out.println("------------------------");
            System.out.print("Enter choice > ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    listPassengers(cruise);
                    break;
                case 2:
                    assignCabin(cruise, sc);
                    break;
                case 3:
                    joinExcursion(cruise, sc);
                    break;
                case 4:
                    listExcursions(cruise);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);
    }

    // --------------------------------------------------
    // MENU OPTION 1 – LIST PASSENGERS
    // --------------------------------------------------

    /**
     * Lists all passengers currently on the cruise.
     * Displays their name and assigned cabin (if any).
     *
     * @param cruise the active cruise
     */
    private static void listPassengers(Cruise cruise) {
        System.out.println("\nPassengers on the cruise:");
        for (Passenger p : cruise.getPassengers()) {
            System.out.print("- " + p.getName());
            if (p.getCabin() != null) {
                System.out.print(" (Cabin " + p.getCabin().getNumber() + ")");
            }
            System.out.println();
        }
    }

    // --------------------------------------------------
    // MENU OPTION 2 – ASSIGN CABIN
    // --------------------------------------------------

    /**
     * Assigns a cabin to an existing passenger.
     *
     * @param cruise the active cruise
     * @param sc scanner for user input
     */
    private static void assignCabin(Cruise cruise, Scanner sc) {

        System.out.print("Enter passenger name > ");
        String name = sc.nextLine();

        Passenger passenger = null;
        for (Passenger p : cruise.getPassengers()) {
            if (p.getName().equalsIgnoreCase(name)) {
                passenger = p;
                break;
            }
        }

        if (passenger == null) {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.print("Enter cabin number > ");
        int number = Integer.parseInt(sc.nextLine());

        for (Cabin c : cruise.getShip().getCabins()) {
            if (c.getNumber() == number) {
                c.addPassenger(passenger);
                System.out.println("Cabin assigned.");
                return;
            }
        }

        System.out.println("Cabin not found.");
    }

    // --------------------------------------------------
    // MENU OPTION 3 – JOIN EXCURSION
    // --------------------------------------------------

    /**
     * Allows a passenger to join an excursion.
     *
     * @param cruise the active cruise
     * @param sc scanner for user input
     */
    private static void joinExcursion(Cruise cruise, Scanner sc) {

        System.out.print("Enter passenger name > ");
        String name = sc.nextLine();

        Passenger passenger = null;
        for (Passenger p : cruise.getPassengers()) {
            if (p.getName().equalsIgnoreCase(name)) {
                passenger = p;
                break;
            }
        }

        if (passenger == null) {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.println("Available excursions:");
        for (Excursion e : cruise.getExcursions()) {
            System.out.println("- " + e);
        }

        System.out.print("Enter day of excursion > ");
        String day = sc.nextLine();

        for (Excursion e : cruise.getExcursions()) {
            if (e.getDayOfWeek().equalsIgnoreCase(day)) {
                passenger.joinExcursion(e);
                System.out.println("Excursion joined.");
                return;
            }
        }

        System.out.println("Excursion not found.");
    }

    // --------------------------------------------------
    // MENU OPTION 4 – LIST EXCURSIONS
    // --------------------------------------------------

    /**
     * Lists all excursions and shows how many passengers
     * have joined each one.
     *
     * @param cruise the active cruise
     */
    private static void listExcursions(Cruise cruise) {

        System.out.println("\nExcursions:");
        for (Excursion e : cruise.getExcursions()) {
            System.out.println(e + " | Passengers: " + e.getPassengers().size());
        }
    }
}