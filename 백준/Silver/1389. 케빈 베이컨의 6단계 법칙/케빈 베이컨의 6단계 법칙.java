import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] friends;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        friends = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            boolean[] visited = new boolean[n + 1];
            int[] count = bfs(i, visited);
            int candidate = 0;

            for (int j = 0; j < n + 1; j++) {
                candidate += count[j];
            }

            friends[i] = candidate;
            min = Math.min(min, candidate);
        }

        for (int i = 0; i < n + 1; i++) {
            if (friends[i] == min) {
                System.out.println(i);
                break;
            }
        }

    }

    static int[] bfs(int start, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] count = new int[n + 1];
        count[start] = 0; //나와의 관계값은 0

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int user = queue.poll();

            for (int i = 0; i < graph[user].size(); i++) {
                int friend = graph[user].get(i);

                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.add(friend);
                    count[friend] = count[user] + 1;
                }
            }
        }

        return count;
    }
}
