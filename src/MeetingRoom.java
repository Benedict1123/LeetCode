import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.
 *
 * For example,
 * Given [ [0, 30], [5, 10], [15, 20] ],
 * return false.
 * Java Solution
 *
 * If a person can attend all meetings, there must not be any overlaps between any meetings.
 * After sorting the intervals, we can compare the current end and next start.
 *
 * */

public class MeetingRoom {

    public static boolean canAttendMeetings(int[][] intervals) {
        int[] allTimestamp = new int[intervals.length * 2]; // candidate timeline
        Set startPoint = new HashSet();
//        Set endPoint = new HashSet();
        for(int i = 0; i < intervals.length; i++){
            allTimestamp[i] = intervals[i][0];
            allTimestamp[i+1] = intervals[i][1];
            startPoint.add(allTimestamp[i] = intervals[i][0]);
        }
        Arrays.sort(allTimestamp); // sorted array
        boolean ifStarted = false;
        for(int eachTimestamp: allTimestamp){
            if (startPoint.contains(eachTimestamp)){
                if(ifStarted){
                    return false;
                }else{
                    ifStarted = true;
                }
            }else {
                ifStarted = false;
            }
        }

        return true;
    }

    public static void main(String[]args){
        int[][] newList = new int[3][];
        newList[0] = new int[]{0,30};
        newList[1] = new int[]{5,10};
        newList[2] = new int[]{15,20};
        boolean result = canAttendMeetings(newList);
        System.out.println(result);
    }
}
