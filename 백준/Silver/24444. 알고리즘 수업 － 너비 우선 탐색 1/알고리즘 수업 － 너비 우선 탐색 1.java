import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        order = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        bfs(r);
        for (int i = 1; i < n + 1; i++) {
            System.out.println(order[i]);
        }
    }

    public static void bfs(int r) {
        order[r] = cnt++;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(r);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (order[v] == 0) {
                    queue.offer(v);
                    order[v] = cnt++;
                }
            }
        }

    }
}