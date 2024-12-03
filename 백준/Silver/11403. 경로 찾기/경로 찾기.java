import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[][] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int start, int currNode) {
        //따로 종료조건을 넣어주지 않아도 알아서 루프를 돌고 나감

        for (int i = 0; i < graph.length; i++) {
            if (graph[currNode][i] == 1 && !visited[i]) {//방문하지 않은 위치며, 연결되어있다면
                visited[i] = true;
                answer[start][i] = 1;
                dfs(start, i);
            }
        }
    }
}
