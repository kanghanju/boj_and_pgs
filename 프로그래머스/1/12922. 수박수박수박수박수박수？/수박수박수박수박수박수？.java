class Solution {
    public String solution(int n) {
        String answer = "";
        int num = n / 2;
        
        for(int i = 0; i < num; i++) {
            answer += "수박";
        }
        
        answer += (n % 2 == 1) ? "수" : "";
        return answer;
    }
}