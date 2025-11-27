package lab5;

import java.util.Scanner;

public class lab53 {

    static class TicTacToe {

        public enum Cell {
            X, O, EMPTY
        }

        private Cell[][] board;

        public TicTacToe() {
            board = new Cell[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = Cell.EMPTY;
                }
            }
        }

        public void printBoard() {
            System.out.println("\nТекущее поле:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (board[i][j]) {
                        case X: System.out.print(" X "); break;
                        case O: System.out.print(" O "); break;
                        case EMPTY: System.out.print("   "); break;
                    }
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
                if (i < 2) System.out.println("---+---+---");
            }
        }

        public boolean makeMove(int row, int col, Cell player) {
            if (row < 0 || row > 2 || col < 0 || col > 2) return false;
            if (board[row][col] != Cell.EMPTY) return false;

            board[row][col] = player;
            return true;
        }

        public Cell checkWinner() {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] != Cell.EMPTY &&
                        board[i][0] == board[i][1] &&
                        board[i][1] == board[i][2])
                    return board[i][0];

                if (board[0][i] != Cell.EMPTY &&
                        board[0][i] == board[1][i] &&
                        board[1][i] == board[2][i])
                    return board[0][i];
            }

            if (board[0][0] != Cell.EMPTY &&
                    board[0][0] == board[1][1] &&
                    board[1][1] == board[2][2])
                return board[0][0];

            if (board[0][2] != Cell.EMPTY &&
                    board[0][2] == board[1][1] &&
                    board[1][1] == board[2][0])
                return board[0][2];

            return null;
        }

        public boolean isDraw() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (board[i][j] == Cell.EMPTY) return false;
            return checkWinner() == null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        TicTacToe.Cell currentPlayer = TicTacToe.Cell.X;
        boolean gameEnded = false;

        System.out.println("Игра Крестики-нолики (X против O)");

        while (!gameEnded) {
            game.printBoard();
            System.out.println("Игрок " + currentPlayer + ", введите номер строки (0-2) и столбца (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!game.makeMove(row, col, currentPlayer)) {
                System.out.println("Некорректный ход. Попробуйте снова.");
                continue;
            }

            TicTacToe.Cell winner = game.checkWinner();
            if (winner != null) {
                game.printBoard();
                System.out.println("Поздравляем! Игрок " + winner + " победил!");
                gameEnded = true;
            } else if (game.isDraw()) {
                game.printBoard();
                System.out.println("Ничья!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == TicTacToe.Cell.X) ? TicTacToe.Cell.O : TicTacToe.Cell.X;
            }
        }

        scanner.close();
    }
}
