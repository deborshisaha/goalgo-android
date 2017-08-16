package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {

    public static void driver() {
        FractionalKnapsack knapsacker = new FractionalKnapsack();

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(20, 100, "2"));
        items.add(new Item(10, 60, "1"));
        items.add(new Item(30, 120, "3"));
        System.out.println(knapsacker.totalValue(items, 50) + " - value of the knapsack");

    }

    public float totalValue(ArrayList<Item> items, float limit) {

        ArrayList<Item> result = new ArrayList();

        Collections.sort(items);

        float spaceLeft = limit;
        float cost = 0;

        for (Item item : items) {

            if (spaceLeft > 0 && item.w < spaceLeft) {
                result.add(item);
                spaceLeft = spaceLeft - item.w;
                cost = cost + item.cost;
            } else if (spaceLeft > 0 && item.w > spaceLeft) {
                cost = cost + (spaceLeft * item.getRatio());
                spaceLeft = 0;
            }

            if (spaceLeft == 0) {
                break;
            }
        }

        return cost;
    }
}

class Item implements Comparable<Item> {

    float w;
    float cost;
    String identifier;

    public Item(float weight, float cost, String identifier) {
        this.w = weight;
        this.cost = cost;
        this.identifier = identifier;
    }

    public float getRatio() {
        return cost / w;
    }

    @Override
    public int compareTo(Item that) {
        float difference = that.getRatio() - this.getRatio();
        return (int) (difference * 100);
    }

}
