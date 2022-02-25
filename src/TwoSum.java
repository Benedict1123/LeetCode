import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *Description
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. [smaller, larger]
 *
 * Please note that your returned answers (both index1 and index2) are zero-based.
 *
 *
 * Example
 * Example 1:
 *
 * Input:
 *
 * numbers = [2,7,11,15]
 * target = 9
 * Output:
 *
 * [0,1]
 * Explanation:
 *
 * numbers[0] + numbers[1] = 9
 *
 * Example 2:
 *
 * Input:
 *
 * numbers = [15,2,7,11]
 * target = 9
 * Output:
 *
 * [1,2]
 * Explanation:
 *
 * numbers[1] + numbers[2] = 9
 *
 * Challenge
 * Either of the following solutions are acceptable:
 *
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 *
 *
 *
 * */

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return [index1, index2] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
//        ArrayList<Arrays<Integer>>
        int[] result = new int[2];
        HashMap<Integer, Integer> pairsMap = new HashMap();
        for(int i = 0; i < numbers.length; i++){
            if(!pairsMap.containsKey(target - numbers[i])){ // the hashmap doesn't contain the other part for current number
                pairsMap.put(numbers[i], i); // add the other part in the hashmap and store the index as well
            } else {
                result[0] = pairsMap.get(target - numbers[i]);  // the hashmap contains the other part for the current number, get the previous index
                result[1] = i; // put current index
            }
        }
        return result;
    }

    public static ArrayList<int[]> twoSumAllCombo(int[] numbers, int target) {
        // write your code here
        ArrayList<int[]> all_combo = new ArrayList<>();
        HashMap<Integer, Integer> pairsMap = new HashMap();
        for(int i = 0; i < numbers.length; i++){
            if(!pairsMap.containsKey(target - numbers[i])){ // the hashmap doesn't contain the other part for current number
                pairsMap.put(numbers[i], i); // add the other part in the hashmap and store the index as well
            } else {
                int[] result = new int[2];
                result[0] = pairsMap.get(target - numbers[i]);  // the hashmap contains the other part for the current number, get the previous index
                result[1] = i; // put current index
                all_combo.add(result);
            }
        }
        return all_combo;
    }

    public static void main(String[] args){
        int[] input = new int[]{2,7,11,15,3,4,1,6,5};
        int targetNumber = 7;
        int[] result =  twoSum(input,targetNumber);
        ArrayList<int[]> result2 =  twoSumAllCombo(input,targetNumber);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.deepToString((result2.toArray())));

    }

}
