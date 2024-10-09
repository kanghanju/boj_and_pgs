import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] charArr = s.toCharArray();
        
        for (int offset = 0; offset < charArr.length; offset++) {
            if (isCorrect(charArr,offset)) answer++;
        }
        
        return answer;
    }
    
    public boolean isCorrect(char[] charArr,int offset) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < charArr.length; i++) {
            //회전시키기 
            char c = charArr[(i + offset) % charArr.length];
            
            switch(c) {
                    case '('-> stk.push(')');
                    case '{' -> stk.push('}');
                    case '[' -> stk.push(']');
                    case ')','}',']' -> {
                        if (stk.isEmpty()) return false;
                        if (stk.peek() != c) return false;
                        stk.pop();
                    }
            }
        }
        
        return stk.isEmpty();
    }
}