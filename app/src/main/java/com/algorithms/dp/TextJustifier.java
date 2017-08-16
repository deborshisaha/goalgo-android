package com.algorithms.dp;

public class TextJustifier {

    public static void driver() {
        System.out.println();
        System.out.println();
        TextJustifier textJustifier = new TextJustifier();
        String[] words = new String[]{"Deborshi", "loves", "to", "write", "code"};
        String justifiedText = textJustifier.justifiedText(words, 16);
        System.out.println(justifiedText);
    }

    public String justifiedText(String[] words, int width) {

        // Cost matrix
        int[][] cost = getCostMatrix(words, width);

        // Cuts
        int[] cuts = new int[words.length];

        // Min cost
        int[] minCost = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            // initialize each cut with word.length
            cuts[i] = words.length;
            // initialize with i,words.length-1
            minCost[i] = cost[i][words.length - 1];
            // start building cut and mincost
            for (int j = words.length - 1; j > i; j--) {
                // If cost contains a really high value, skip
                if (cost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                // Update min cost CRITICAL STEP
                if (minCost[j] + cost[i][j - 1] < minCost[i]) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    cuts[i] = j;
                }
            }
        }

        return stitchData(cuts, words);
    }

    private int[][] getCostMatrix(String[] words, int width) {

        int[][] cost = new int[words.length][words.length];
        for (int r = 0; r < words.length; r++) {
            cost[r][r] = width - words[r].length();
            for (int c = r + 1; c < words.length; c++) {
                cost[r][c] = cost[r][c - 1] - words[c].length() - 1;
            }
        }

        return cost;
    }

    private String stitchData(int[] cuts, String[] words) {

        if (cuts.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer();

        int startIdx = 0;
        int stopIdx = 0;

        while (stopIdx < words.length) {
            stopIdx = cuts[startIdx];
            System.out.println("stopIdx:" + stopIdx);
            for (int k = startIdx; k < stopIdx; k++) {
                sb.append(words[k] + " ");
            }
            sb.append("\n");
            startIdx = stopIdx;
        }

        return sb.toString();
    }
}
