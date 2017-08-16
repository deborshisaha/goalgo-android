package com.algorithms.recursion;

public class NQueen implements ValidityChecker {

    private ChessBoard board = null;

    public boolean solve(ChessBoard board1, int row, int col) {
        
        this.board = board1;

        if (row == 8) {
            return false;
        }

        while (col < this.board.getSize()) {

            if (this.board.putQueen(row, col)) {

                if (this.board.getCount('Q') == 8) {
                    this.board.print();
                }

                boolean isValid = isNextValid(board1, row, col);

                if (!isValid) {
                    this.board.clearQueen(row, col);
                    col++;
                    continue;
                }
                return true;
            } else {
                return isNextValid(this.board, row, col);
            }
        }

        return false;

    }

    public boolean isNextValid(ChessBoard board, int row, int col) {
        int nxtC = 0;
        int nxtR = 0;
        
        if (col == (board.getSize() - 1)) {
            nxtR = row + 1;
            nxtC = 0;
        } else {
            nxtC = col + 1;
            nxtR = row;
        }
        
        return this.solve(board, nxtR, nxtC);
    }

    public static void driver() {
        NQueen nqueen = new NQueen();
        ChessBoard board = new ChessBoard(8, nqueen);
        nqueen.solve(board, 0, 0);
        //board.print();
    }

    @Override
    public boolean isValid(int r, int c) {
        boolean isDiagonal1Good = isDiagonal1Good(r, c);
        boolean isDiagonal2Good = isDiagonal2Good(r, c);
        boolean isHorizontalGood = isHorizontalGood(r, c);
        boolean isVerticalGood = isVerticalGood(r, c);

        return (isDiagonal1Good && isDiagonal2Good
                && isHorizontalGood && isVerticalGood); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isDiagonal1Good(int r, int c) {

        int iteratorR = r - 1;
        int iteratorC = c - 1;

        while (iteratorC >= 0 && iteratorR >= 0) {
            if (this.board.get(iteratorR, iteratorC) == 'Q') {
                return false;
            }
            iteratorC--;
            iteratorR--;
        }

        iteratorR = r + 1;
        iteratorC = c + 1;

        while (iteratorC < this.board.getSize() && iteratorR < this.board.getSize()) {
            if (this.board.get(iteratorR, iteratorC) == 'Q') {
                return false;
            }
            iteratorC++;
            iteratorR++;
        }

        return true;
    }

    private boolean isDiagonal2Good(int r, int c) {
        int iteratorR = r - 1;
        int iteratorC = c + 1;

        while (iteratorC < this.board.getSize() && iteratorR >= 0) {
            if (this.board.get(iteratorR, iteratorC) == 'Q') {
                return false;
            }
            iteratorC++;
            iteratorR--;
        }

        iteratorR = r + 1;
        iteratorC = c - 1;

        while (iteratorC >= 0 && iteratorR < this.board.getSize()) {
            if (this.board.get(iteratorR, iteratorC) == 'Q') {
                return false;
            }
            iteratorC--;
            iteratorR++;
        }

        return true;
    }

    private boolean isHorizontalGood(int r, int c) {

        int iteratorC = c - 1;

        while (iteratorC >= 0) {
            if (this.board.get(r, iteratorC) == 'Q') {
                return false;
            }
            iteratorC--;
        }

        iteratorC = c + 1;

        while (iteratorC < this.board.getSize()) {
            if (this.board.get(r, iteratorC) == 'Q') {
                return false;
            }
            iteratorC++;
        }

        return true;
    }

    private boolean isVerticalGood(int r, int c) {

        int iteratorR = r - 1;

        while (iteratorR >= 0) {
            if (this.board.get(iteratorR, c) == 'Q') {
                return false;
            }
            iteratorR--;
        }

        iteratorR = r + 1;

        while (iteratorR < this.board.getSize()) {
            if (this.board.get(iteratorR, c) == 'Q') {
                return false;
            }
            iteratorR++;
        }

        return true;
    }
}

interface ValidityChecker {

    public boolean isValid(int r, int c);
}

class ChessBoard {

    char[][] board = null;
    NQueen vc = null;

    private int size = 0;

    public int getSize() {
        return size;
    }

    public ChessBoard(int size, NQueen nqueen) {
        this.board = new char[size][size];
        this.vc = nqueen;
        this.size = size;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                this.board[r][c] = ' ';
            }
        }
    }

    public void clearQueen(int r, int c) {
        this.board[r][c] = ' ';
    }

    public boolean putQueen(int r, int c) {
        this.board[r][c] = 'Q';

        if (!vc.isValid(r, c)) {
            clearQueen(r, c);
            return false;
        }

        return true;
    }

    public char get(int r, int c) {
        return this.board[r][c];
    }

    public void print() {
        int size = board.length;
        System.out.println("+-+-+-+-+-+-+-+-+");
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print("|" + this.board[r][c]);
                if (c == (size - 1)) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.print("+-+-+-+-+-+-+-+-+");
            System.out.println();
        }
    }

    public int getCount(char ch) {
        int size = board.length;
        int count = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (this.board[r][c] == ch) {
                    count++;
                }
            }

        }

        return count;
    }
}
