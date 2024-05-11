class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        
        while(n >= a) {
            int exchangeNum = n / a; 
            result += (exchangeNum * b); 
            n = n - (exchangeNum * a) + (exchangeNum * b);
        }
        
        return result;
    }
}