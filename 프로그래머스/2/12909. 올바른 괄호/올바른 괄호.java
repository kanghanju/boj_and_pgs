import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();

        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            switch (c) {
                case '(' -> stk.push('(');
                case ')' -> {
                    if (stk.isEmpty()) {
                        return false;
                    }
                    stk.pop();
                }
            }
        }

        return stk.isEmpty(); 
    }
}