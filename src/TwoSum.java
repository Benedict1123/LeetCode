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
        int[] result = new int[2];
        HashMap<Integer, Integer> pairsMap = new HashMap();
        for(int i = 0; i < numbers.length; i++){
            if(!pairsMap.containsKey(target - numbers[i])){
                pairsMap.put(numbers[i], i);
            } else {
                result[0] = pairsMap.get(target - numbers[i]);
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{2,7,11,15};
        int targetNumber = 9;
        int[] result =  twoSum(input,targetNumber);
        System.out.println(Arrays.toString(result));
    }

}
