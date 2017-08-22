package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.BestMeetingPoint;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsaha on 8/22/17.
 */

public class BestMeetingPointTest {


    @Test
    public void basic_test () throws Exception {
        BestMeetingPoint obj = new BestMeetingPoint();
        int [][] input = new int[][] {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0},{0, 0, 1, 0, 0}};
        assertTrue( obj.minimumTotalDistance(input) == 6);
    }
}
