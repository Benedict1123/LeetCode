import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Given a string S, we can transform every letter individually to be lowercase or uppercase
 * to create another string.
 *
 * Return a list of all possible strings we could create.
 *
 * Example
 * Example 1:
 *
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 *
 * Example 2:
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 *
 * Example 3:
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 * */


public class LetterCasePermutation {

    /**
     * idea: find each element, storing their index;
     *
     * for each letter, find all possible combinations
     *
     * if n letters, total number of combinations will be 2^n
     *
     * use a hashMap for element and index storage;
     * use a candidate map
     *
     * */
//    public static List<String> LetterCasePermutation(String S){
//
//    }
    private static List<String> list = new ArrayList<>();
    private static char[] arr;

    public static List<String> letterCasePermutation(String S) {
        arr = S.toCharArray();
        return dfs(0, new StringBuilder());
    }

    public static List<String> dfs(int index, StringBuilder sb) {
        // out of index
        if (index >= arr.length) {
            list.add(sb.toString());
            return list;
        }
        dfs(index+1, new StringBuilder(sb).append(arr[index]));
        // for letters
        if (arr[index] >= 'a')
            dfs(index+1, new StringBuilder(sb).append((char)(arr[index]-32))); // to uppercase
        else if (arr[index] >= 'A')
            dfs(index+1, new StringBuilder(sb).append((char)(arr[index]+32))); // to lowercase
        return list;
    }


    public static void main(String[] args){
        List<String> result = letterCasePermutation("aaac12b");
        System.out.println(result);
    }

}
