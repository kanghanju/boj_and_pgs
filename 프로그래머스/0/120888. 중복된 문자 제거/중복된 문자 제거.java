import java.util.*; 

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(); 

        for (int i = 0; i < my_string.length(); i++) {
            if (set.contains(my_string.charAt(i))) {
                continue;
            }
            set.add(my_string.charAt(i));
            sb.append(my_string.charAt(i));
        }

        return sb.toString(); 
    }
}