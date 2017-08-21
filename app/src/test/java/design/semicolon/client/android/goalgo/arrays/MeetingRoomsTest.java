package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.MeetingRooms;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 8/20/17.
 */

public class MeetingRoomsTest {

    @Test
    public void basic_test () throws Exception {

        MeetingRooms obj = new MeetingRooms();
        MeetingRooms.MeetingSchedule ms1 = new MeetingRooms.MeetingSchedule(910,900);
        MeetingRooms.MeetingSchedule ms2 = new MeetingRooms.MeetingSchedule(1200,940);
        MeetingRooms.MeetingSchedule ms3 = new MeetingRooms.MeetingSchedule(1120,950);
        MeetingRooms.MeetingSchedule ms4 = new MeetingRooms.MeetingSchedule(1130,1100);
        MeetingRooms.MeetingSchedule ms5 = new MeetingRooms.MeetingSchedule(1900,1500);
        MeetingRooms.MeetingSchedule ms6 = new MeetingRooms.MeetingSchedule(2000,1800);

        MeetingRooms.MeetingSchedule[] meetings = new MeetingRooms.MeetingSchedule[]{ms1,ms2,ms3,ms4,ms5,ms6};
        int rooms = obj.getMeetingRoomsNeeded(meetings);

        assertTrue(rooms == 3);

    }
}
