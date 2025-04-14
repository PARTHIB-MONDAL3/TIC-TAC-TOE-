import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char currentPlayer = 'X';
        boolean gameEnded = false;
        int moves = 0;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded && moves < 9) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                placeMove(move, currentPlayer);
                printBoard();
                if (checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    moves++;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!gameEnded) {
            System.out.println("The game is a draw!");
        }
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int pos) {
        int[] coords = getCoordinates(pos);
        return board[coords[0]][coords[1]] == ' ';
    }

    public static void placeMove(int pos, char symbol) {
        int[] coords = getCoordinates(pos);
        board[coords[0]][coords[1]] = symbol;
    }

    public static int[] getCoordinates(int pos) {
        switch (pos) {
            case 1: return new int[]{0, 0};
            case 2: return new int[]{0, 2};
            case 3: return new int[]{0, 4};
            case 4: return new int[]{2, 0};
            case 5: return new int[]{2, 2};
            case 6: return new int[]{2, 4};
            case 7: return new int[]{4, 0};
            case 8: return new int[]{4, 2};
            case 9: return new int[]{4, 4};
            default: return new int[]{-1, -1};
        }
    }

    public static boolean checkWinner(char symbol) {
        // Rows, Columns, Diagonals
        return (
                (board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
                        (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
                        (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||

                        (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
                        (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
                        (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||

                        (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
                        (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol)
        );
    }
}

