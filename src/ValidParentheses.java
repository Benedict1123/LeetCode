import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Description
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Example
 * Example 1:
 *
 * Input: "([)]"
 * Output: False
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: True
 * Challenge
 * Use O(n) time, n is the number of parentheses.
 *
 * "(" "[" "{" are for adding into the memo, ")" "]" "}" are the triggers to pop the last item in the memo
 *
 * */
public class ValidParentheses {
    public static boolean isValidParentheses(String s) {
        int stringLength = s.length();
        if(stringLength == 0 || stringLength%2 != 0 ){  // the length is an odd number, won't make it
            return false;
        }
        ArrayList<String> bufferList = new ArrayList<>();// buffer memory to store added parenthesis
        int bufferSize = bufferList.size();
        for(String eachChar: s.split("")){
            if(eachChar.equals("(")|| eachChar.equals("[") || eachChar.equals("{")){ // if they're the starting points
                bufferList.add(eachChar);
                bufferSize = bufferList.size();
            }else { // if the current string is not a starting part, it is an ending part, compare it with the last element in the memo
                if(bufferSize>0){// there must be some "start" parts added already, if not then false
                    if(eachChar.equals(")") && bufferList.get(bufferSize-1).equals("(")
                    || eachChar.equals("]") && bufferList.get(bufferSize-1).equals("[")
                    || eachChar.equals("}") && bufferList.get(bufferSize-1).equals("{")){ // conditions that a pair is found, and remove the last element
                        bufferList.remove(bufferSize-1);
                        bufferSize = bufferList.size();
                    }else { // the pair condition isn't satisfied
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if(bufferSize > 0) return false; // at the end of the loop, if it makes it, all pairs should be cleared
        return true;
    }

    /**
     * Solution 2, utilising a stack structure
     * */
    public static boolean isValidParenthesesTwo(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)  // keep popping the stack
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        boolean result = isValidParentheses("({{([])}})");
        System.out.println(result);
    }
}
