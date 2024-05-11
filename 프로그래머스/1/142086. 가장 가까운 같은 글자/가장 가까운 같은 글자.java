class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        
        for(int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(alphabet[index] == -1) {
                alphabet[index] = i;
                answer[i] = -1;
            } else {
                int before = alphabet[index];
                alphabet[index] = i;
                answer[i] = (i - before);
            }
        }
        
        return answer;
    }
}