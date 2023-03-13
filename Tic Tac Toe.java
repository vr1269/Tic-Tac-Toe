import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();

        System.out.println("Welcome to Tic Tac Toe!");

        while (!isGameFinished()) {
            printBoard();
            makeMove();
            changePlayer();
        }

        printBoard();
        declareWinner();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static void makeMove() {
        int row, col;

        do {
            System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
            row = input.nextInt() - 1;

            System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
            col = input.nextInt() - 1;

        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid row or column!");
            return false;
        }

        if (board[row][col] != '-') {
            System.out.println("This cell is already occupied!");
            return false;
        }

        return true;
    }

    static void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean isGameFinished() {
        return (isBoardFull() || isWinner('X') || isWinner('O'));
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    static void declareWinner() {
        if (isWinner('X')) {
            System.out.println("Player X wins!");
       
