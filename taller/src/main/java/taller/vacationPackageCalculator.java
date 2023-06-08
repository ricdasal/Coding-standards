// Copyright (C) 2020
// All rights reserved

package taller;
import java.util.Scanner;

public final class VacationPackageCalculator {
	//CHECKSTYLE:OFF
	/**
	 * Calculate base cost.
	 */
	private static final int BASECOST = 1000;
	/**
	 * Additional cost = 500.
	 */
	private static final int ADITIONALCOST500 = 500;
	/**
	 * Additional cost = 600.
	 */
	private static final int ADITIONALCOST600 = 600;
	/**
	 * numTravelers = 4.
	 */
	private static final int TRAVELERS4 = 4;
	/**
	 * numTravelers = 10.
	 */
	private static final int TRAVELERS10 = 10;
	/**
	 * DISCOUNT 20 PERCENT.
	 */
	private static final double TOTALCOSTDISCOUNT20PERCENT = 0.2;
	/**
	 * DISCOUNT 10 PERCENT.
	 */
	private static final double TOTALCOSTDISCOUNT10PERCENT = 0.1;
	/**
	 * duration = 7.
	 */
	private static final int DURATION7 = 7;
	/**
	 * totalCost = 200.
	 */
	private static final double TOTALCOST200 = 200;
	/**
	 * duration = 30.
	 */
	private static final int DURATION30 = 30;
	/**
	 * numTravelers = 2.
	 */
	private static final int TRAVELERS2 = 2;
	/**
	 * numTravelers = 80.
	 */
	private static final int TRAVELERS80 = 80;
	/**
	 * ADDON = 200.
	 */
	private static final int ADDON200 = 200;
	/**
	 * ADDON = 150.
	 */
	private static final int ADDON150 = 150;
	/**
	 * ADDON = 100.
	 */
	private static final int ADDON100 = 100;
	/**
	 * STRING WITH VAULE 1.
	 */
	private static final String STRINGONE = "1";
	/**
	 * STRING WITH VALUE 2.
	 */
	private static final String STRINGTWO = "2";
	/**
	 * STRING WITH VAULE 3.
	 */
	private static final String STRINGTHREE = "3";

	private VacationPackageCalculator() {
	}

	/**
	 * This is the main method that serves as the entry point of the program
	 * It accepts command-line arguments as an array of strings.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(final String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        // Input: Destination
        System.out.println("Available destinations: ");
        System.out.println("1. Paris");
        System.out.println("2. New York City");
        System.out.print("Select a destination (1 or 2): ");
        int destinationChoice = scanner.nextInt();
        // Input: Number of travelers
        System.out.print("Enter the number of travelers: ");
        int numTravelers = scanner.nextInt();

        // Input: Duration of vacation in days
        System.out.print("Enter the duration of the vacation in days: ");
        int duration = scanner.nextInt();
        // Apply additional cost based on destination
        int additionalCost = 0;
        switch (destinationChoice) {
            case 1:
                additionalCost = ADITIONALCOST500;
                break;
            case 2:
                additionalCost = ADITIONALCOST600;
                break;
            default:
                System.out.println("Invalid destination choice.");
                System.out.println("Total cost: -1");
                return;
        }
        int totalCost = BASECOST + additionalCost;
        // Apply group discount
        if (numTravelers > TRAVELERS4 && numTravelers <= TRAVELERS10) {
            totalCost -= totalCost * TOTALCOSTDISCOUNT10PERCENT;
        } else if (numTravelers > TRAVELERS10) {
            totalCost -= totalCost * TOTALCOSTDISCOUNT20PERCENT;
        }
        // Apply penalty fee for short duration
        if (duration < DURATION7) {
            totalCost += TOTALCOST200;
        }
        // Apply promotion policy for long duration or 2 passengers
        if (duration > DURATION30 || numTravelers == TRAVELERS2) {
            totalCost -= TOTALCOST200;
        }
        // Check if the group size exceeds the limit
        if (numTravelers > TRAVELERS80) {
            System.out.println("Group size exceeds the limit.");
            System.out.println("Total cost: -1");
            return;
        }
        // Apply optional add-ons
        System.out.println("Available add-ons: ");
        System.out.println("1. All-Inclusive Package ($200 per traveler)");
        System.out.println("2. Adventure Activities Package $150 per traveler");
        System.out.println("3. Spa and Wellness Package ($100 per traveler)");
        System.out.print("Select add-ons (comma-separated numbers): ");
        String addOns = scanner.next();
        String[] addOnsArray = addOns.split(",");
        int addOnsCost = 0;
        for (String addOn : addOnsArray) {
        	String trimmedAddOn = addOn.trim();

            if (STRINGONE.equals(trimmedAddOn)) {
                addOnsCost += ADDON200 * numTravelers;
            } else if (STRINGTWO.equals(trimmedAddOn)) {
                addOnsCost += ADDON150 * numTravelers;
            } else if (STRINGTHREE.equals(trimmedAddOn)) {
                addOnsCost += ADDON100 * numTravelers;
            } else {
                System.out.println("Invalid add-on choice.");
                System.out.println("Total cost: -1");
                return;
            }
        }
        totalCost += addOnsCost;
        // Output total cost
        System.out.println("Total cost: $" + totalCost);
    }
	//CHECKSTYLE:ON

}
