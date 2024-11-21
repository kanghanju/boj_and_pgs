class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    //순열 -> 순서를 신경쓴다, 조합 -> 순서 신경  안쓴다
    static void dfs(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth + 1);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}