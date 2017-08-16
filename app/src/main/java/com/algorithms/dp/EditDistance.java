package com.algorithms.dp;

public class EditDistance {

    public static void driver() {
        System.out.println();
        System.out.println();

        EditDistance editDistanceFinder = new EditDistance();

        String string1 = "abcfe";
        String string2 = "abdfeg";

        int distance = editDistanceFinder.distance(string1, string2);
        System.out.println("Edit distance: " + distance);
    }

    public int distance(String string1, String string2) {
        int[][] cost = buildCost(string1, string2);
        
        return cost[string1.length()][string2.length()];
    }

    private int[][] buildCost(String string1, String string2) {
        
        int[][] cost = new int[string1.length() + 1][string2.length() + 1];

        for (int c = 0; c <= string2.length(); c++) {
            cost[0][c] = c;
        }

        for (int r = 0; r <= string1.length(); r++) {
            cost[r][0] = r;
        }

        for (int r = 1; r <= string1.length(); r++) {
            for (int c = 1; c <= string2.length(); c++) {
                if (string2.charAt(c - 1) == string1.charAt(r - 1)) {
                    // Both are same then borrow diagonally
                    cost[r][c] = cost[r - 1][c - 1];
                } else {
                    cost[r][c] = Math.min(Math.min(cost[r - 1][c - 1], cost[r][c - 1]), cost[r - 1][c]) + 1;
                }
            }
        }

        return cost;
    }

    void print(int[][] cost, int rowLen, int colLen) {
        for (int r = 0; r <= rowLen; r++) {
            for (int c = 0; c <= colLen; c++) {
                System.out.print(cost[r][c] + " ");
            }

            System.out.println();
        }
    }
}
