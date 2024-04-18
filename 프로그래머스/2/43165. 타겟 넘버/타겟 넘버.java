class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, target, 0);
        return answer;
    }
    
    private static int dfs(int[] numbers,int sum,int target,int pos) {
        int answer = 0;
        
        if(pos == numbers.length){//재귀가 끝날 조건 
            if(sum == target) {
                return 1; //sum == target이라면 answer += 1
            }
            return 0;
        }
        
        //더하거나 빼는 경우를 나눔 
        answer += dfs(numbers,sum + numbers[pos], target, pos + 1);
        answer += dfs(numbers,sum - numbers[pos], target, pos + 1);
        
        return answer;
    }
}