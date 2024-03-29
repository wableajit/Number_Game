package com.ajit;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int rounds, totalAttempts = 0;

        System.out.print("How many rounds do you want to play? ");
        rounds = scanner.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = playRound(lowerLimit, upperLimit, targetNumber);
            totalAttempts += attempts;
        }

        System.out.println("\nGame over! Total attempts: " + totalAttempts);
        System.out.println("Average attempts per round: " + (double) totalAttempts / rounds);
        scanner.close();
    }

    public static int playRound(int lowerLimit, int upperLimit, int targetNumber) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        return attempts;
    }
}
