import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    // Maximum attempts per round
    private static final int MAX_ATTEMPTS = 10;

    // Minimum range for random number
    private static final int RANGE_MIN = 1;

    // Maximum range for random number
    private static final int RANGE_MAX = 100;

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        // Welcome message
        System.out.println("===============================================");
        System.out.println("      Welcome to the Number Guessing Game!         ");
        System.out.println("===============================================");

        while (playAgain) {
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Game instructions
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("    Guess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
            System.out.println("    You have " + MAX_ATTEMPTS + " attempts to guess the correct number.");
            System.out.println("-------------------------------------------------------------------");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("===============================================");
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("===============================================");

                    // Higher score for fewer attempts
                    score += MAX_ATTEMPTS - attempts - 1;
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.\n");
                } else {
                    System.out.println("Too high! Try again.\n");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(
                        "\nSorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            // Display Score
            System.out.println("\n-----------------------------------------------");
            System.out.println("             Your score: " + score);
            System.out.println("-----------------------------------------------");

            System.out.print("\nDo you want to play again [Y/N]?: ");
            String response = scanner.next();

            playAgain = response.equalsIgnoreCase("Y");
        }

        System.out.println("\n===============================================");
        System.out.println("Thank you for playing! Your final score is " + score + ".         ");
        System.out.println("===============================================");
        scanner.close();
    }
}
