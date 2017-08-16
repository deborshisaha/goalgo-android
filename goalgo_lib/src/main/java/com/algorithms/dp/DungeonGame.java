package com.algorithms.dp;

public class DungeonGame {

    public static void driver() {
        DungeonGame obj = new DungeonGame();
        int[][] d = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, 5}};
        System.out.println("Dungeon Game:" + obj.minimumStartingHealth(d));
    }

    public int minimumStartingHealth(int[][] d) {

        int rows = d.length;
        int columns = d[0].length;

        int[][] iH = new int[rows][columns];

        iH[rows - 1][columns - 1] = Math.max(1, 1 - d[rows - 1][columns - 1]);

        for (int r = rows - 2; r >= 0; r--) {
            iH[r][columns - 1] = Math.max(1, iH[r + 1][columns - 1] - d[r][columns - 1]);
        }

        for (int c = columns - 2; c >= 0; c--) {
            iH[rows - 1][c] = Math.max(1, iH[rows - 1][c + 1] - d[rows - 1][c]);
        }

        for (int r = rows - 2; r >= 0; r--) {
            for (int c = columns - 2; c >= 0; c--) {
                iH[r][c] = Math.max(1, Math.min(iH[r + 1][c], iH[r][c + 1]) - d[r][c]);
            }
        }

        return iH[0][0];
    }
}
