import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static int sideLen;
    static int[][] dir = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sideLen = Integer.parseInt(br.readLine());
            String[] current = br.readLine().split(" ");
            String[] target = br.readLine().split(" ");
            int[] currentPos = new int[]{Integer.parseInt(current[0]),
                Integer.parseInt(current[1])};
            int[] targetPos = new int[]{Integer.parseInt(target[0]), Integer.parseInt(target[1])};

            System.out.println(bfs(currentPos, targetPos));
        }

    }

    static int bfs(int[] start, int[] end) {
        graph = new int[sideLen][sideLen];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start[0], start[1], 0});
        graph[start[0]][start[1]] = 1; //방문 표시

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }

            for (int i = 0; i < 8; i++) {
                int nextX = dir[i][0] + cur[0];
                int nextY = dir[i][1] + cur[1];

                if (!isValid(nextX, nextY) || graph[nextX][nextY] == 1) {
                    continue;
                } else {
                    graph[nextX][nextY] = 1;
                    q.add(new int[]{nextX, nextY, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= sideLen || y < 0 || y >= sideLen) {
            return false;
        }
        return true;
    }
}
