package com.algorithms;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;

public class SudokuBox {

    private Box[] boxes = null;
    
    public SudokuBox() {
    }

    public SudokuBox(String filePath) {
        
        this.boxes = new Box[]{new Box(), new Box(), new Box(), new Box(), new Box(), new Box(), new Box(), new Box(), new Box()};

        try {

            Stream<String> stream = Files.lines(Paths.get(filePath));

            Iterable<String> iterable = stream::iterator;

            for (String s : iterable) {

                char[] array = s.toCharArray();
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        int index = 9 * r + c;
                        if (array[index] == '.') {
                            put(0, r, c);
                        } else {
                            put(array[index] - '0', r, c);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty(int i, int j) {
        int number = get(i, j);
        return number == 0;
    }

    private Box getBox(int r, int c) {
        if ((r >= 0 && r < 3) && (c >= 0 && c < 3)) {
            return this.boxes[0];
        } else if ((r >= 0 && r < 3) && (c >= 3 && c < 6)) {
            return this.boxes[1];
        } else if ((r >= 0 && r < 3) && (c >= 6 && c < 9)) {
            return this.boxes[2];
        } else if ((r >= 3 && r < 6) && (c >= 0 && c < 3)) {
            return this.boxes[3];
        } else if ((r >= 3 && r < 6) && (c >= 3 && c < 6)) {
            return this.boxes[4];
        } else if ((r >= 3 && r < 6) && (c >= 6 && c < 9)) {
            return this.boxes[5];
        } else if ((r >= 6 && r < 9) && (c >= 0 && c < 3)) {
            return this.boxes[6];
        } else if ((r >= 6 && r < 9) && (c >= 3 && c < 6)) {
            return this.boxes[7];
        } else if ((r >= 6 && r < 9) && (c >= 6 && c < 9)) {
            return this.boxes[8];
        }

        return null;
    }

    private int translateCtoBoxC(int c) {
        return ((c >= 0 && c < 3) ? c : ((c >= 3 && c < 6) ? (c - 3) : (c - 6)));
    }

    private int translateRtoBoxR(int row) {
        return ((row >= 0 && row < 3) ? row : ((row >= 3 && row < 6) ? (row - 3) : (row - 6)));
    }

    public int get(int r, int c) {
        int effectiveColumn = translateCtoBoxC(c);
        int effectiveRow = translateRtoBoxR(r);

        Box b = getBox(r, c);
        if (b != null) {
            return b.get(effectiveRow, effectiveColumn);
        }

        return -1;
    }

    public boolean put(int v, int r, int c) {

        int effectiveColumn = translateCtoBoxC(c);
        int effectiveRow = translateRtoBoxR(r);
        Box b = getBox(r, c);

        if (b != null) {

            if (v == 0) {
                b.put(0, effectiveRow, effectiveColumn);
                // Do not check validity
                return true;
            }

            b.put(v, effectiveRow, effectiveColumn);
        }

        if (!isValid()) {
            b.put(0, effectiveRow, effectiveColumn);
            return false;
        }

        return true;
    }

    private boolean verticallyValid() {

        boolean isValid = true;

        for (int col = 0; col < 9; col++) {

            isValid = columnChecker(col);

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    private boolean rowChecker(int row) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int c = 0; c < 9; c++) {

            int number = get(row, c);

            if (set.contains(number)) {
                return false;
            } else {
                if (number != 0) {
                    set.add(number);
                }
            }

        }

        return true;
    }

    private void printRow(int row) {
        System.out.print("|");
        for (int c = 0; c < 9; c++) {
            Integer number = get(row, c);
            String string = ((number == 0) ? "_" : number.toString());
            if (c == 2 || c == 5 || c == 8) {
                System.out.print(string + "|");
            } else {
                System.out.print(string + " ");
            }
        }
        System.out.println();
    }

    private boolean columnChecker(int col) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int r = 0; r < 9; r++) {

            int number = get(r, col);

            if (set.contains(number)) {
                return false;
            } else {
                if (number != 0) {
                    set.add(number);
                }
            }
        }

        return true;
    }

    private boolean horizontallyValid() {

        boolean isValid = true;

        for (int row = 0; row < 9; row++) {

            isValid = rowChecker(row);

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    private boolean are3x3Valid() {

        for (Box b : boxes) {
            if (!b.isValid()) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid() {
        return verticallyValid() && horizontallyValid() && are3x3Valid();
    }

    public void print() {

        for (int row = 0; row < 9; row++) {
            if ((row) % 3 == 0) {
                System.out.println("+-----+-----+-----+");
            }
            printRow(row);
        }
        System.out.println("+-----+-----+-----+");
    }

}

class Box {

    private int[][] mat = new int[9][9];

    public Box() {
        this.mat = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    public boolean isValid() {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                if (mat[r][c] == 0) {
                    continue;
                }

                if (set.contains(mat[r][c])) {
                    return false;
                } else {
                    set.add(mat[r][c]);
                }
            }
        }
        return true;
    }

    public int get(int r, int c) {
        return mat[r][c];
    }

    public void put(int v, int r, int c) {
        mat[r][c] = v;
    }
}
