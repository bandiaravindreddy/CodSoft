import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int secretNumber;
        int attempts;
        int maxAttempts = 5;
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("I have chosen a number between 1 and " + maxRange + ". Can you guess it?");
            secretNumber = random.nextInt(maxRange) + 1;
            attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
                }
            }

            totalAttempts += attempts;
            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total attempts: " + totalAttempts);
        
        scanner.close();
    }
}
