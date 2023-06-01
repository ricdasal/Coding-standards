// Copyright (C) 2020
// All rights reserved

package taller;
import java.util.Scanner;

public class vacationPackageCalculator {
	
	private static final double GROUP_DISCOUNT_10_PERCENT = 0.1;
	
	private static final double GROUP_DISCOUNT_20_PERCENT = 0.2;
	
	//CHECKSTYLE:OFF
	/**
	 * This is the main method that serves as the entry point of the program.
	 * It accepts command-line arguments as an array of strings.
	 *
	 * @param args the command-line arguments
	 */
	public static void main (String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        // Get user inputs
        System.out.print ("Enter the destination of the vacation (Paris or New York City): ");
        String destination = scanner.nextLine().trim();

        System.out.print ("Enter the number of travelers: ");
        int numberOfTravelers = scanner.nextInt();

        System.out.print("Enter the duration of the vacation in days: ");
        int duration = scanner.nextInt();

        // Validate input
        if (!isValidInput(destination, numberOfTravelers, duration)) {
            System.out.println ("Invalid input. Please check your inputs and try again.");
            System.out.println ("The vacation package calculation cannot proceed.");
            return;
        }

        // Calculate vacation package cost
        int baseCost = 1000;
        int additionalCost = calculateAdditionalCost(destination);
        int totalCost = baseCost + additionalCost;

        if (numberOfTravelers > 4 && numberOfTravelers < 10) {
            totalCost -= totalCost * GROUP_DISCOUNT_10_PERCENT; // Apply 10% group discount
        } else if (numberOfTravelers > 10) {
            totalCost -= totalCost * GROUP_DISCOUNT_20_PERCENT; // Apply 20% group discount
        }

        if (duration < 7) {
            totalCost += 200; // Add penalty fee
        }

        if (duration > 30 || numberOfTravelers == 2) {
            totalCost -= 200; // Apply promotion policy
        }

        // Check if the group size exceeds the limit
        if (numberOfTravelers > 80) {
            System.out.println ("The vacation package is not available for groups of more than 80 persons.");
            System.out.println ("The vacation package calculation cannot proceed.");
            return;
        }

        // Display the total cost
        System.out.println("The total cost of the vacation package is: $" + totalCost);
    }
	
	/**
	 * Checks if the input for the vacation package is valid.
	 *
	 * @param destination      the destination of the vacation
	 * @param numberOfTravelers the number of travelers
	 * @param duration         the duration of the vacation in days
	 * @return true if the input is valid, false otherwise
	 */
    private static boolean isValidInput (String destination, int numberOfTravelers, int duration) {
        // Check if destination is valid
        if (!destination.equalsIgnoreCase("Paris") && !destination.equalsIgnoreCase("New York City")) {
            return false;
        }

        // Check if the number of travelers and duration are positive
        if (numberOfTravelers <= 0 || duration <= 0) {
            return false;
        }

        return true;
    }
    
    /**
     * Calculates the additional cost for the given destination.
     *
     * @param destination the destination for which to calculate the additional cost
     * @return the additional cost for the destination
     */
    private static int calculateAdditionalCost (String destination) {
    	destination = destination.toLowerCase();
        
        if (destination.equals("paris")) {
            return 500;
        } else if (destination.equals("new york city")) {
            return 600;
        } else {
            return 0;
        }
    }

	
	//CHECKSTYLE:ON

}
