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

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the correct number.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    
                    // Higher score for fewer attempts
                    score += MAX_ATTEMPTS - attempts + 1;
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("\nToo low! Try again.");
                } else {
                    System.out.println("\nToo high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            // Display Score
            System.out.println("\nYour score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();

            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing! Your final score is " + score + ".");
        scanner.close();
    }
}
