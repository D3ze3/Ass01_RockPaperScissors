import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            // Get valid input for Player A
            String playerA = getValidMove(scanner, "Player A");

            // Get valid input for Player B
            String playerB = getValidMove(scanner, "Player B");

            // Determine the winner and print the result
            determineWinner(playerA, playerB);

            // Ask if they want to play again
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().trim();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Method to get valid move input (R, P, S) from player
    private static String getValidMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.next().trim().toUpperCase();
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));
        return move;
    }

    // Method to determine the winner and display results
    private static void determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println(playerA + " vs " + playerB + " - It's a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            printGameResult(playerA, playerB);
            System.out.println("Player A wins!");
        } else {
            printGameResult(playerB, playerA);
            System.out.println("Player B wins!");
        }
    }

    // Method to print the standard game phrase
    private static void printGameResult(String winnerMove, String loserMove) {
        if (winnerMove.equals("R") && loserMove.equals("S")) {
            System.out.println("Rock breaks Scissors.");
        } else if (winnerMove.equals("P") && loserMove.equals("R")) {
            System.out.println("Paper covers Rock.");
        } else if (winnerMove.equals("S") && loserMove.equals("P")) {
            System.out.println("Scissors cuts Paper.");
        }
    }
}
