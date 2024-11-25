import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        String[] people = br.readLine().split(" ");
        int person1 = Integer.parseInt(people[0]);
        int person2 = Integer.parseInt(people[1]);
        int edge = Integer.parseInt(br.readLine());

        graph = new ArrayList[node + 1];
        for (int i = 0; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            String[] relation = br.readLine().split(" ");
            int parent = Integer.parseInt(relation[0]);
            int child = Integer.parseInt(relation[1]);

            //양방향 그래프
            graph[child].add(parent);
            graph[parent].add(child);
        }

        int result = bfs(person1, person2);
        System.out.println(result);

    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[graph.length];
        distance = new int[graph.length];

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                return distance[current];
            }

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}
