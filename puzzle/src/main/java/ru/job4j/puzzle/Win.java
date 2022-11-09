package ru.job4j.puzzle;

public class Win {
    public static boolean monoHorizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int index = 0; index < board.length; index++) {
            if (board[row][index] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public static boolean monoVertical(int[][] board, int cell) {
        boolean rsl = true;
        for (int index = 0; index < board.length; index++) {
            if (board[index][cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1 && (monoHorizontal(board, index) || monoVertical(board, index))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
