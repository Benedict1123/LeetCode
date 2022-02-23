import java.util.Arrays;
import java.util.HashMap;

/**
 * Revenue Milestones
 * We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.
 * Signature
 * int[] getMilestoneDays(int[] revenues, int[] milestones)
 * Input
 * revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is a length-K array of total revenue milestones.
 * Output
 * Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue. If the milestone is never met, return -1.
 * Example
 * revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * milestones = [100, 200, 500]
 * output = [4, 6, 10]
 * Explanation
 * On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that FB has >= $200 of total revenue.
 *
 * */

public class RevenueMilestones {

    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] outputList = new int[milestones.length];
        int totalSumRev = 0;
        HashMap<Integer,Integer> cumulativeRev = new HashMap<>();
        // cumulative sum
        for(int i = 0; i<revenues.length;i++){
            totalSumRev += revenues[i];
            cumulativeRev.put(i+1,totalSumRev);
        }
//        System.out.println(cumulativeRev);
        outer: for(int i = 0;i<milestones.length;i++){
            for(int j = 0; j < revenues.length; j++){
                if(cumulativeRev.get(j+1)>= milestones[i]){
                    outputList[i] = j+1;
                    continue outer;
                }
            }
            outputList[i] = -1;
        }
        return outputList;

    }

    public static void main(String[] args) {
        int []revenues = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = new int[]{100, 200, 500};
        int[] result = getMilestoneDays(revenues,milestones);
        System.out.println(Arrays.toString(result));
    }
}
