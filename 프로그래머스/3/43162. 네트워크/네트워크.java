class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers,i,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int[][] computers, int startV, int n) {
        for (int i = 0; i < n; i++) {
            if (computers[startV][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers, i, n);
            }
        }
    }
}