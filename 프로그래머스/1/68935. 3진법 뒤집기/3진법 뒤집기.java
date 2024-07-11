class Solution {
    public int solution(int n) {
        String num = Integer.toString(n,3);
        String reversed = new StringBuilder(num).reverse().toString();
        
        return Integer.parseInt(reversed,3);
    }
}