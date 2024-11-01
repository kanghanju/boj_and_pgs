import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] set;
    static boolean[] visited;
    static int[] order; //1번부터 n번까지 순서대로 방문순서를 출력해야 하므로 만든 배열 
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        set = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];

        for (int i = 0; i < set.length; i++) {
            set[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            set[u].add(v);
            set[v].add(u);
        }

        for (int i = 0; i < set.length; i++) {
            Collections.sort(set[i]);
        }

        dfs(r);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(order[i]);
        }
    }

    public static void dfs(int r) {
        visited[r] = true;
        order[r] = cnt++;

        for (int i = 0; i < set[r].size(); i++) {
            if (!visited[set[r].get(i)]) {
                dfs(set[r].get(i));
            }
        }
    }
}