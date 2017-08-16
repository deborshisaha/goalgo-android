package com.algorithms.arrays;

public class TotalScore {

    public int getTotalScore(String[] blocks) {
        
        int totalScore = 0;
        int score = 0;
        int prevScore = 0;
        int prevPrevScore = 0;
        
        for (String block : blocks) {
            
            if (isInteger(block)) {
                prevPrevScore = prevScore;
                prevScore = score;
                score = Integer.parseInt(block);
                totalScore += score;
            } else if (block.charAt(0) == 'X') {
                totalScore += (score * 2);
            } else if (block.charAt(0) == '+') {
                totalScore += (score + prevScore);
            } else if (block.charAt(0) == 'Z') {
                totalScore = totalScore - score;
                score = prevScore;
                prevScore = prevPrevScore;
            }
            
        }
        
        return totalScore;
    }
    
    private boolean isInteger (String string) {
        try {
            Integer number = Integer.parseInt(string);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        
        return true;
    }
    
    static public void driver() {
        TotalScore totalScore = new TotalScore();
        String[] blocks = {"5","-2", "X","9","+","+"};
        //String[] blocks = {"1","2","+","X"};
        System.out.println("Total Score:"+ totalScore.getTotalScore(blocks));
    }

}
