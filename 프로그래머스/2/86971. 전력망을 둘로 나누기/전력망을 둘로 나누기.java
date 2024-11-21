import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //노드와 연결되어있는 다른 노드 표시
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            boolean[] visited = new boolean[n + 1];

            //해당 간선을 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            count = 0;
            dfs(1, visited);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);

            //해당 간선을 다시 연결
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        return answer;
    }

    static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        count++;

        for (int i = 0; i < graph[start].size(); i++) {
            int node = graph[start].get(i);
            if (!visited[node]) {
                dfs(node, visited);
            }
        }
    }

}