import java.util.Scanner;

/**
 * Program allows the user to check the result of a competition that uses the winning condition 'best of seven'.
 *
 * @author Tim Knops
 */
public class BestOfSeven {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dit programma is gemaakt door Tim Knops, IS101, 500849389");

        final int MAX_GAMES = 7, MAX_SCORE = 4;

        System.out.print("\nNaam van team 1: ");
        String team1Name = scanner.nextLine();
        System.out.print("Naam van team 2: ");
        String team2Name = scanner.nextLine();

        int[] team1Arr = new int[MAX_GAMES], team2Arr = new int[MAX_GAMES];

        int currentGame = 0, team1Score = 0, team2Score = 0;
        do {
            String winningTeam = playGame(team1Name, team2Name, team1Arr, team2Arr, currentGame);
            if (winningTeam.equals(team1Name)) {
                team1Score++;
            } else {
                team2Score++;
            }

            currentGame++;
        } while (team1Score < MAX_SCORE && team2Score < MAX_SCORE);

        // Setting up variables for printing the winner, this is done to reduce redundancy within
        // the printWinner() method.
        String teamWon = team1Score > team2Score ? team1Name : team2Name;
        int firstScoreDisplay = Math.max(team1Score, team2Score);
        int secondScoreDisplay = Math.min(team1Score, team2Score);

        printWinner(teamWon, currentGame, firstScoreDisplay, secondScoreDisplay);
        printStatistics(team1Name, team2Name, team1Arr, team2Arr, currentGame);
    }

    /**
     * Plays a single round of a game.
     *
     * @param team1Name Name of the first team.
     * @param team2Name Name of the second team.
     * @param team1Arr Array of team1 that contains all game scores.
     * @param team2Arr Array of team2 that contains all game scores.
     * @param currentGame Current game that is being played.
     *
     * @return Name of the team that won.
     */
    public static String playGame(String team1Name, String team2Name, int[] team1Arr, int[] team2Arr,
                                  int currentGame) {
        System.out.printf("\nUitslag wedstrijg %d\n", currentGame + 1);

        // Reading of each game scores.
        System.out.printf("\tAantal punten %s: ", team1Name);
        team1Arr[currentGame] = scanner.nextInt();

        System.out.printf("\tAantal punten %s: ", team2Name);
        team2Arr[currentGame] = scanner.nextInt();

        // Returns name of team that won.
        return team1Arr[currentGame] > team2Arr[currentGame] ? team1Name : team2Name;
    }

    /**
     * Prints the winning team, as well as the ending scores.
     *
     * @param teamWon Name of the team that won.
     * @param playedGames Amount of games that were played.
     * @param firstScore The team that reached the required score of MAX_SCORE first.
     * @param secondScore The team that reached the required score of MAX_SCORE second.
     */
    public static void printWinner(String teamWon, int playedGames, int firstScore, int secondScore) {
        System.out.printf("\nAantal gespeelde wedstrijden: %d\n", playedGames);
        System.out.printf("%s heeft gewonnen met %d - %d\n\n", teamWon, firstScore, secondScore);
    }

    /**
     * Prints out the array after the displaying of the score at the end of all the games.
     *
     * @param team1Name Name of the first team.
     * @param team2Name Name of the second team.
     * @param team1Arr Array of team1 that contains all game scores.
     * @param team2Arr Array of team2 that contains all game scores.
     * @param playedGames Amount of games that were played.
     */
    public static void printStatistics(String team1Name, String team2Name, int[] team1Arr, int[] team2Arr,
                                       int playedGames) {
        for (int i = 1; i <= playedGames; i++) {
            System.out.printf("wedstrijd %d: %s - %s %d - %d\n", i, team1Name, team2Name, team1Arr[i - 1],
                                                                 team2Arr[i - 1]);
        }
    }
}
