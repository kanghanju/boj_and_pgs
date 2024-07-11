class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        int cntZero = 0;
        int cnt = 0;
        
        while(!s.equals("1")) {
            int zeros = countZeros(s);
            cntZero += zeros;
        
            int len = s.length() - zeros;
            s = Integer.toString(len,2);
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = cntZero;

        return answer;
    }
    
    private int countZeros(String s) {
        int zeros = 0;
        for(char c : s.toCharArray()) {
            if(c =='0')zeros++;
        }
        return zeros;
    }
}