class Solution {
    public String solution(String s) {
        String[] words = s.split("");
        String answer = "";
        int count = 1;

        for(int i = 0; i < words.length; i++) {
            count = (words[i].contains(" ")) ? 1 : count + 1;
            if(count % 2 == 0) answer += words[i].toUpperCase();
            else answer += words[i].toLowerCase();
        }

        return answer;
    }
}