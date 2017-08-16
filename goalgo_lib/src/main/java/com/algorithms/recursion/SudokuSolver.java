package com.algorithms.recursion;

import com.algorithms.SudokuBox;

public class SudokuSolver {

    /*
    put
    Assumptions that insertion checks if the value being inserted validates the sudoku
    i.e. if the value being inserted is not valid, then roll back the value
    
    isEmpty
    Sudoku class provides an API which return true if a box is empty
    
    get
    Sudoku class would return the integer at index row,column
    
    */
    private SudokuBox sudokuBox = null;

    public SudokuSolver() {}

    public SudokuSolver(SudokuBox sudoku) {
        this.sudokuBox = sudoku;
    }

    private boolean solveUtil(int row, int col) {

        // If we ever reach this case, it means we are done processing the sudoku
        // return true
        if (row == 9) {
            return true;
        }
        
        // If this box is empty then try filling it out
        // Otherwise goto next box
        if (this.sudokuBox.isEmpty(row, col)) {
            // Try all different options to fill out the box 1-9
            for (int i = 1; i < 10; i++) {

                // If putting 'i' makes the sudoku invalid then put returns falls
                if (this.sudokuBox.put(i, row, col)) {
                    
                    // if putting the value succeeded at 8,8 then we're done processing
                    if (row == 8 && col == 8) {
                        // return true
                        return true;
                    }
                    
                    // Continue with the next row and column
                    if (!isNextValid(row, col)) {
                        // With the current value of i, things didn't work out well
                        // rollback or reset this box and try again with next value of i
                        this.sudokuBox.put(0, row, col);
                    } else {
                        // With current value of i, things were good so return true at this point
                        return true;
                    }
                }
            }
            // Exhausted all attempts. Not solvable 
            return false;
        } else {
            // Go to next empty box
            return isNextValid(row, col);
        }

    }

    public boolean isNextValid(int row, int col) {

        int nextCol = 0;
        int nextRow = 0;

        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        return solveUtil(nextRow, nextCol);
    }

    // Is it to find solution for a Sudoku?
    public void solve() {
        if (solveUtil(0, 0)) {
            this.sudokuBox.print();
        } else {
            System.out.println("Not a valid Sudoku");
        }
        
    }

    public static void driver() {
        SudokuBox sudokuBox = new SudokuBox("/Users/dsaha/Desktop/sudoku.txt");
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuBox);
        System.out.println("Before");
        sudokuSolver.sudokuBox.print();
        System.out.println("\nAfter");
        sudokuSolver.solve();

    }
}
