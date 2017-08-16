package com.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<String, Character> map = new HashMap();

    public static void driver() {
        DecodeWays decodeWaysFinder = new DecodeWays();
        System.out.print(decodeWaysFinder.ways("123"));
    }

    public DecodeWays() {
        this.map.put("1", 'A');
        this.map.put("2", 'B');
        this.map.put("3", 'C');
        this.map.put("4", 'D');
        this.map.put("5", 'E');

        this.map.put("6", 'F');
        this.map.put("7", 'G');
        this.map.put("8", 'H');
        this.map.put("9", 'I');
        this.map.put("10", 'J');

        this.map.put("11", 'K');
        this.map.put("12", 'L');
        this.map.put("13", 'M');
        this.map.put("14", 'N');
        this.map.put("15", 'O');

        this.map.put("16", 'P');
        this.map.put("17", 'Q');
        this.map.put("18", 'R');
        this.map.put("19", 'S');
        this.map.put("20", 'T');

        this.map.put("21", 'U');
        this.map.put("22", 'V');
        this.map.put("23", 'W');
        this.map.put("24", 'X');
        this.map.put("25", 'Y');
        
        this.map.put("26", 'Z');
    }

    public int ways(String input) {

        return 0;
    }
}
