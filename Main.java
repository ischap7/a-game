//Ismail Chapman
//2/19/2024
//CIS 1068 Assignment 4 A Game


import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static int numUserWins = 0;
    private static int numComputerWins = 0;

    public static void main(String[] args) {
        // The rules should be printed to the screen
        printRules();

        // Continue playing rounds until the user chooses not to
        while (continuePlayRound()) {
            playRound();
        }

        // Print the final game statistics
        printGameStats();
    }

    // Method to print the game rules
    public static void printRules() {
        System.out.println("\nDuring each round, players choose a move, " +
                "\nwhich may be either Fjallbo, Oxberg, Vittsjo, Jattesta, or Ekenabben. " +
                "\nThe rules are: Ekenabben beats Vittsjo, Fjallbo; " +
                "\nVittsjo beats Oxberg, Jattesta; Oxberg beats Ekenabben, Fjallbo; " +
                "\nFjallbo Beats Jattesta, Vittsjo; Jattesta beats Ekenabben, Oxberg. " +
                "\nThe computer wins in the event of a tie.");
    }

    //  The user is asked if they'd like to play a round
    public static boolean continuePlayRound() {
        //if they choose 'n', the program ends
        //The user is asked if they'd like to continue
        System.out.print("Would you like to play a round? (y/n): ");
        char charUserInput = scanner.next().charAt(0);
        //if they choose 'y', a round is played
        return charUserInput == 'y';
    }

    // Method to play a round of the game
    public static void playRound() {
        String userMove = getUserMove();
        String computerMove = getComputerMove();

        // Determine the winner of the round and update game statistics
        determineWinner(userMove, computerMove);

        // Display the current number of user and computer wins
        System.out.println("Number of user wins: " + numUserWins);
        System.out.println("Number of computer wins: " + numComputerWins);
    }

    // Method for the user to enter their move
    public static String getUserMove() {
        String validMoves = "FjallboOxbergVittsjoJattestaEkenabben";
        String userInput;
        //The user is asked to enter a move, which may be either
        // Fjallbo, Oxberg, Vittsjo, Jattesta, or Ekenabben.
        // The program should continue to prompt the user until a valid move is entered.
        do {
            System.out.print("Enter move (Fjallbo, Oxberg, Vittsjo, Jattesta, Ekenabben): ");
            userInput = scanner.next();

            // Check if the entered move is valid
            if (!validMoves.contains(userInput)) {
                System.out.println("Invalid input. Please enter a valid move.");
            }

        } while (!validMoves.contains(userInput));

        System.out.println("You chose: " + userInput);
        return userInput;
    }

    //The computer makes a move at random.
    public static String getComputerMove() {
        String[] moves = {"Fjallbo", "Oxberg", "Vittsjo", "Jattesta", "Ekenabben"};
        int randomIndex = random.nextInt(moves.length);
        String computerMove = moves[randomIndex];
        System.out.println("Computer chose: " + computerMove);
        return computerMove;
    }

    //  Determine the winner
    public static void determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if ((userMove.equals("Ekenabben") && (computerMove.equals("Vittsjo") || computerMove.equals("Fjallbo")))
                || (userMove.equals("Vittsjo") && (computerMove.equals("Oxberg") || computerMove.equals("Jattesta")))
                || (userMove.equals("Oxberg") && (computerMove.equals("Ekenabben") || computerMove.equals("Fjallbo")))
                || (userMove.equals("Fjallbo") && (computerMove.equals("Jattesta") || computerMove.equals("Vittsjo")))
                || (userMove.equals("Jattesta") && (computerMove.equals("Ekenabben") || computerMove.equals("Oxberg")))) {
            numUserWins++;
            //The program prints the computer's move,
            // the user's move, and who is the winner of this round.
            System.out.println("You win!");
        } else {
            numComputerWins++;
            System.out.println("Computer wins!");
        }
    }

    // When the user has decided to quit the game, the program prints the number of
    public static void printGameStats() {
        System.out.println("Game Over!");
        //rounds played
        System.out.println("Number of rounds played: " + (numUserWins + numComputerWins));
        //times the user won
        System.out.println("Number of user wins: " + numUserWins);
        //times the computer won
        System.out.println("Number of computer wins: " + numComputerWins);
    }
}
