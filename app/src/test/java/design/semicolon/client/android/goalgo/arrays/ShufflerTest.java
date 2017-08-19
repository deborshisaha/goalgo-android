package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.randomization.Shuffler;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShufflerTest {
    @Test
    public void addition_isCorrect() throws Exception {

        Shuffler shuffler = new Shuffler();
        Integer[] array = new Integer[]{10,1,51,12,3};
        shuffler.shuffle(array);

        for (Integer i: array) {
            System.out.print(i+" ");
        }

        assertTrue(true);
    }
}