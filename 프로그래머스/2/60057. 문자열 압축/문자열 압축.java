import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for(int length = 1; length <= s.length(); length++) {
            int len = compress(s,length);
            
            if(len < min) min = len;
        }
        
        return min;
    }
    
    private int compress(String s,int length) {
        StringBuilder sb = new StringBuilder();
        String last = ""; //전에있는 문자열과 비교할 때 필요한 변수 
        int count = 0;
        
        for(String token : split(s,length)) {
            if(!token.equals(last)) {
                if(count > 1) sb.append(count); //1일때는 붙지않아도됨
                sb.append(last);//token을 붙이면 처음부터 이상해진다..
                count = 1;
                last = token; 
            } else {
                count++; 
            }
        }
        
        if(count > 1) sb.append(count);
        sb.append(last);
        
        return sb.length();
    }
    
    private List<String> split(String s,int length) {
        List<String> tokens = new ArrayList<>();
        
        for(int startIdx = 0; startIdx < s.length(); startIdx += length) {
            int endIdx = startIdx + length; 
            
            if(endIdx > s.length()) endIdx = s.length();
            
            tokens.add(s.substring(startIdx,endIdx));
        }
        
        return tokens;
    }
}