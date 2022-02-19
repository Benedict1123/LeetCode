/**
 *
 * LeetCode 168
 *
 *Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 *
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 *
 * Input: columnNumber = 701
 * Output: "ZY"
 *
 *
 * Constraints:
 *
 * 1 <= columnNumber <= 231 - 1
 *
 * */


public class ExcelSheetColumn {

    /**
     * for input n
     * Idea: variables to calculate: quotient and residuals.
     *
     * problem: 26 letters (char) 'A' to 'Z' -> 10 digits (decimal) mapping
     *
     * 0:25 -> 0:9 conversion
     *
     * */


//    static String allLetters = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static String getResultTitle(int columnNum){

        StringBuilder sb = new StringBuilder();
        while (columnNum > 0) {
            columnNum--;
            sb.append((char)(columnNum % 26 + 'A'));
            columnNum /= 26;
        }
        sb.reverse();
        return sb.toString();

    }


    public static void main(String[] args){
        int num = 38;
        String resultTitle = getResultTitle(num);
        System.out.println(resultTitle);
        System.out.println((char)(1 + 'A'));
    }
}
