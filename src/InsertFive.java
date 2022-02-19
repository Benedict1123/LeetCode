/**
 * Description
 * Given a number, insert a 5 at any position of the number to make the number largest after insertion.
 *
 * Example
 * Example 1:
 *
 * Input:  a = 234
 * Output: 5234
 *
 * Input: a = -44675
 * Output: -445675
 * */

public class InsertFive {
    /**
     * @param a: A number; |a| <= 10^6
     * @return Returns the maximum number after insertion
     */
    public static int InsertFive(int a) {
        // write your code here
        int digitLength = String.valueOf(Math.abs(a)).length(); // digits of the number
        int result;
        int digitIndex = 0;
        char[] letterArray = String.valueOf(Math.abs(a)).toCharArray();
        if(a>=0){
            // keep looking for the firs time that current digit is greater than 5
            for(char eachNum: letterArray){
                if(Integer.parseInt(Character.toString(eachNum))>=5){ // if the current digit number is greater than 5, then it is necessary to put 5 before it
                    digitIndex++;
                }else {
                    break;
                }
            }
            if(digitIndex == digitLength) return (Math.abs(a)*10 + 5); // if 5 has to go to the last digit
            if(digitIndex == 0) return a +  ((int) Math.pow(10,digitLength)*5); // if 5 has to go to the first digit
            String former = String.valueOf(Math.abs(a)).substring(0,digitIndex);
            String latter = String.valueOf(Math.abs(a)).substring(digitIndex,digitLength);
            result =  (int)(Math.pow(10,digitLength-digitIndex+1)*Integer.parseInt(former))
                    + (int)(Math.pow(10,digitLength - digitIndex)*5)
                    + Integer.parseInt(latter);
        }else {
            // keep looking for the first time that 5 is smaller than the current digit
            for(char eachNum: letterArray){
                if(Integer.parseInt(Character.toString(eachNum))>5){ // if the current digit number is greater than 5, then it is necessary to put 5 before it
                    break;
                }else {
                    digitIndex++;
                }
            }
            // result consists of 2 parts: former + latter
            if(digitIndex == digitLength) return (Math.abs(a)*10 + 5)* -1; // if 5 has to go to the last digit
            if(digitIndex == 0) return (Math.abs(a) +  ((int) Math.pow(10,digitLength)*5))*-1; // if 5 has to go to the first digit
            String former = String.valueOf(Math.abs(a)).substring(0,digitIndex);
            String latter = String.valueOf(Math.abs(a)).substring(digitIndex,digitLength);
            result =  (int)(Math.pow(10,digitLength-digitIndex+1)*Integer.parseInt(former))
                    + (int)(Math.pow(10,digitLength - digitIndex)*5)
                    + Integer.parseInt(latter);
            result = result*-1;
        }
        return  result;
    }


    public static void main(String[] args){
        int result = InsertFive(654321);
        System.out.println(result);
    }
}
