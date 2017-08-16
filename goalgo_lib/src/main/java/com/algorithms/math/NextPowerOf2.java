/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.math;

/**
 *
 * @author dsaha
 */
public class NextPowerOf2 {

    private int number = 0;

    public NextPowerOf2(int number) {
        this.number = number;
    }

    public int next() {
        int power = 0;
        while (number != 0) {
            number = number / 2;
            power++;
        }

        return power;
    }
}
