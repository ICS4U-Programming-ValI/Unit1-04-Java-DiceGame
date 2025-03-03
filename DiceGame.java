import java.util.Scanner;
import java.util.Random;

/**
 * This is the package for DiceGame.java
 *
 * The DiceGame program generates a random number between 1 and 6,
 * and the user has to guess the number. The program provides feedback
 * on whether the guess is too high or too low and counts the number of guesses.
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val I
 * @version 1.0
 * @since 2025-02-28
 */
public final class DiceGame {

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args unused.
     */
    public static void main(final String[] args) {
        // Creates instance of Random class
        Random rand = new Random();

        // Generates random int between 1 and 6
        int randInt = rand.nextInt(6) + 1;
        // set default variables
        int counter = 0;
        int userGuess = 0;
        // creates scanner
        Scanner scanner = new Scanner(System.in);
        // Greets user
        System.out.println("Welcome to the Dice Game!");
        System.out.println("Guess a number between 1 and 6:");

        // Loop until the user guesses the correct number
        while (userGuess != randInt) {
            // gets guess from user
            String userGuessStr = scanner.nextLine();
            // makes sure guess is an int using try catch
            try {
                userGuess = Integer.parseInt(userGuessStr);
                // Checks if guess is too high, low or right
                if (userGuess == randInt) {
                    System.out.println("You guessed it!");
                } else if (userGuess > randInt) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
            // adds to counter
            counter = counter + 1;
        }

        // Display the number of guesses
        System.out.println("It took you " + counter + " guesses.");
        scanner.close();
    }
}
