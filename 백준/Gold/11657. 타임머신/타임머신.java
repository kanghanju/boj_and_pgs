import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static List<int[]> edges = new ArrayList<>();
    static long[] dist;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//도시의 개수
        m = Integer.parseInt(st.nextToken());//버스 노선의 개수
        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges.add(new int[]{start, end, time});
        }

        if (bellmanFord(1)) {//음수 사이클이 나온다면
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i] == INF ? "-1" : dist[i]);
            }
        }
    }

    static boolean bellmanFord(int start) {

        for (int i = 1; i < n; i++) {//모든 간선을 n-1번 반복확인: 최단경로를 찾기 위함
            for (int[] edge : edges) {//모든 간선 확인
                int s = edge[0];
                int e = edge[1];
                int time = edge[2];

                if (dist[s] != INF && dist[s] + time < dist[e]) {
                    dist[e] = dist[s] + time;
                }
            }
        }
        //현재 dist에는 1부터 각노드까지의 최단경로시간이 적혀있다

        //음수 사이클 확인을 위해 한 번 더 사이클을 돌려 거리배열 갱신 시도 
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int time = edge[2];

            if (dist[s] != INF && dist[s] + time < dist[e]) {
                return true;
            }
        }

        return false;
    }
}
