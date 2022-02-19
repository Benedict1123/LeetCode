/**
 * LeetCode 1881
 *
 * You are given a very large integer n, represented as a string, and an integer digit x. The digits in n and the digit x are in the inclusive range [1, 9], and n may represent a negative number.
 *
 * You want to maximize n's numerical value by inserting x anywhere in the decimal representation of n. You cannot insert x to the left of the negative sign.
 *
 * For example, if n = 73 and x = 6, it would be best to insert it between 7 and 3, making n = 763.
 * If n = -55 and x = 2, it would be best to insert it before the first 5, making n = -255.
 * Return a string representing the maximum value of n after the insertion.
 *
 * Example 1:
 *
 * Input: n = "99", x = 9
 * Output: "999"
 * Explanation: The result is the same regardless of where you insert 9.
 * Example 2:
 *
 * Input: n = "-13", x = 2
 * Output: "-123"
 * Explanation: You can make n one of {-213, -123, -132}, and the largest of those three is -123.
 *
 * Constraints:
 *
 * 1 <= n.length <= 105
 * 1 <= x <= 9
 * The digits in n are in the range [1, 9].
 * n is a valid representation of an integer.
 * In the case of a negative n, it will begin with '-'.
 *
 * */


public class MaximumValueAfterInsertion {

    public static String maxValue(String n, int x) {
        int digitLength = n.length(); // digits of the number;
        String result;
        int digitIndex = 0;
        if(!n.startsWith("-")){
            char[] letterArray = n.toCharArray();
            // keep looking for the firs time that current digit is greater than 5
            for(char eachNum: letterArray){
                if(Integer.parseInt(Character.toString(eachNum))>=x){ // if the current digit number is greater than 5, then it is necessary to put 5 before it
                    digitIndex++;
                }else {
                    break;
                }
            }
            if(digitIndex == digitLength) return n+x; // if 5 has to go to the last digit
            if(digitIndex == 0)return x+n; // if 5 has to go to the first digit
            String former = n.substring(0,digitIndex);
            String latter = n.substring(digitIndex,digitLength);
            result =  former+x+latter;
        }else {
            digitLength -=1; // for negative numbers, needs to minus the first "-" to calculate the real length.
            n = n.substring(1); // remove the first "-"
            char[] letterArray = n.toCharArray();
            // keep looking for the first time that 5 is smaller than the current digit
            for(char eachNum: letterArray){
                if(Integer.parseInt(Character.toString(eachNum))>x){ // if the current digit number is greater than 5, then it is necessary to put 5 before it
                    break;
                }else {
                    digitIndex++;
                }
            }
            // result consists of 2 parts: former + latter
            if(digitIndex == digitLength) return "-" + n+x; // if 5 has to go to the last digit
            if(digitIndex == 0) return "-" +x+n; // if 5 has to go to the first digit
            String former = n.substring(0,digitIndex);
            String latter = n.substring(digitIndex,digitLength);
            result = "-" + former+x+latter;
        }
        return  result;
    }

    public static void main(String[] args){
        String result = maxValue("469975787943862651173569913153377",3);
        System.out.println(result);
    }
}
