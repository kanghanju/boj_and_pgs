import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");

        Object[] o = Arrays.stream(arr).sorted().toArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < o.length; i++) {
            sb.append(o[i]);
        }
        
        return sb.reverse().toString();
    }
}