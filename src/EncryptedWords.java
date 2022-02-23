/**
 *Encrypted Words
 * You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
 * When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
 * Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
 * Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
 * Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
 * For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
 * If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
 * Input
 * S contains only lower-case alphabetic characters
 * 1 <= |S| <= 10,000
 * Output
 * Return string R, the encrypted version of S.
 * Example 1
 * S = "abc"
 * R = "bac"
 * Example 2
 * S = "abcd"
 * R = "bacd"
 * Example 3
 * S = "abcxcba"
 * R = "xbacbca"
 * Example 4
 * S = "facebook"
 * R = "eafcobok"
 *
 * */

public class EncryptedWords {

    public static String recursiveSplit(String inputStr){
        StringBuilder resStr = new StringBuilder();
        int lengthStr = inputStr.length(); // e.g. 3, 4
        if(lengthStr <= 2){
            resStr.append(inputStr);
            return resStr.toString();
        }
        Character midChar;
        int midIndex = 0;
        if(lengthStr%2 ==0) {// even length
            midIndex = lengthStr/2-1; //'abcd' [1] 4/2 = 2
        }else{// odd length abc [1] 3/2 = 1
            midIndex = lengthStr/2;
        }
        midChar = inputStr.charAt(midIndex);
        String leftStr = inputStr.substring(0,midIndex);
        String rightStr = inputStr.substring(midIndex+1,lengthStr);
        resStr.append(midChar);
        resStr.append(recursiveSplit(leftStr));
        resStr.append(recursiveSplit(rightStr));
        return resStr.toString();
    }

    public static void main(String[] args) {
        String inputStr = "facebook";
//        String b = inputStr.substring(2,3);
        String R = recursiveSplit(inputStr);
        System.out.println(R);
//        System.out.println(b);
//        System.out.println(R);
//        System.out.println(R);
    }
}
