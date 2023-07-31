import java.util.Scanner;

public class TicTacToeGame {

    private static final int[][] board = new int[3][3];

    static {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                board[x][y] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerOrder = 0;

        while (1 == 1) {
            printBoard();
            System.out.println("Player " + (playerOrder % 2 + 1) + " >> Next Move: ");
            String[] coordinates = scanner.nextLine().split(" ");
            if (coordinates.length != 2) {
                System.out.println("Should be entered two coordinates! Try again");
            } else {
                try {
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);

                    if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
                        System.out.println("Coordinates should be between 0 and " + (board.length - 1) + "! Try again!");
                    } else {
                        //TODO: Check coordinate whether empty or not
                        if (board[x][y] != -1) {
                            System.out.println("You can move to this coordinate! It is already occupied! Try different move!");
                        } else {
                            playerOrder = playerOrder % 2;
                            board[x][y] = playerOrder + 1;

                            //TODO: Check board in case of someone wins
                            boolean hasWon = checkBoard(playerOrder + 1);
                            if (hasWon){
                                printBoard();
                                System.out.println("Player " + (playerOrder % 2 + 1) + " won the game!");
                                return;
                            }

                            playerOrder++;
                        }
                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("Should be two coordinates! Try again");
                }
            }

        }
    }

    private static boolean checkBoard(int playerNumber) {
        int diagonalRight = 0;
        int diagonalLeft = 0;
        for (int x = 0; x < board.length; x++) {
            int vertical = 0;
            int horizontal = 0;
            for (int y = 0; y < board[0].length; y++) {

                if (board[x][y] == playerNumber) {
                    vertical++;
                }

                if (board[y][x] == playerNumber) {
                    horizontal++;
                }

                if (x == y && board[y][x] == playerNumber){
                    diagonalRight++;
                }

                if (y == board.length - x - 1 && board[y][x] == playerNumber){
                    diagonalLeft++;
                }

                if (vertical == board.length || horizontal == board.length || diagonalRight == board.length || diagonalLeft == board.length){
                    return true;
                }
            }
        }
        return false;
    }

    private static void printBoard() {
        for (int y = 0; y < board.length; y++) {
            String row = "|";
            for (int x = 0; x < board[0].length; x++) {
                String value = board[x][y] == -1 ? " " : String.valueOf(board[x][y]);
                row = row + value + "|";
                if (x == board[0].length - 1)
                    System.out.println(row);
            }
        }
    }

}
