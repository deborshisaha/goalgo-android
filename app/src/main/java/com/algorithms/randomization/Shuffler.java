package com.algorithms.randomization;

// Fisher Yates Shuffle
public class Shuffler<T> {

    public void shuffle (T[] array) {

        for (int j=array.length-1; j > 0; j--) {
            double random = Math.random();
            int cardToSwap = (int)Math.floor(random*(j+1));

            T temp = array[j];
            array[j] = array[cardToSwap];
            array[cardToSwap] = temp;
        }
    }

    public static void driver() {
        Shuffler shuffler = new Shuffler();
        Integer[] array = new Integer[]{10,1,51,12,3};
        shuffler.shuffle(array);

        for (Integer i: array) {
            System.out.print(i+" ");
        }
    }
}
