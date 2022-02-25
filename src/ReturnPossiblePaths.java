import java.util.*;

/**
 *
 * input as N*N grid;
 *
 * 1 2 3
 * 4 5 6   moving from top left corner to right bottom 1 -> 9. can only move to the Right or Down
 * 7 8 9
 *
 * so a path 1->2->3->6->9  is recorded as 'RRDD',
 *
 * question: how many permutations are there from 'RRDD';
 *
 * ->total permutations of '(N-1)R + (N-1)D'
 *
 * count all possible path strings, and return an array of them
 * */

public class ReturnPossiblePaths {
    /**
     * Problem simplify: total permutations of (N-1) R and (N-1) D
     * RRDD RDRD RDDR DRDR DDRR DRRD
     * */
//    // R:2, D:2
//    private static Set<String> res = new HashSet<>();
//    private static boolean[] visited = new boolean[4];// maximum length of 4
//
//    public static String[] permutation(String s) {
//        char[] chars = s.toCharArray();
//        dfs(chars, 0, ""); // depth first search, starting from index 0
//        return res.toArray(res.toArray(new String[0]));
//    }
//
//    private static void dfs(char[] chars, int index, String s) {
//        if (index == chars.length){ // reaching the last digit
//            res.add(s);
////            return;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (!visited[i]){ // if this character is not used
//                visited[i] = true;
//                dfs(chars, index + 1, s + chars[i]);
//                visited[i] = false;
//            }
//        }
//    }


    private static Set<String> res = new HashSet<>();
    /**
     * given a string RRDD, try to find total permutations of this string
     * */
    public static void permute (int RLeft, int DLeft, int currentStrLength,int targetLength, String currentStr){
        if(currentStrLength == targetLength){ // the length has achieved the target
            res.add(currentStr);
        }

        if(RLeft>0 && currentStrLength < targetLength){ // there's more of R left, then append one more R
            permute(RLeft-1,DLeft,currentStrLength+1,targetLength,currentStr+"R");
        }

        if(DLeft>0 && currentStrLength < targetLength){ // there's more of D left, then append one more D
            permute(RLeft,DLeft-1,currentStrLength+1,targetLength,currentStr+"D");
        }
    }

    public static void main(String[] args){
//        String startStr = "RRDD";
        permute(2,2,0,4,"");
        System.out.println(res);  // the answer is [DRRD, RDRD, RRDD, RDDR, DRDR, DDRR]
//        String[] result = permutation(startStr);
//        System.out.println(Arrays.toString(result));
    }

}
