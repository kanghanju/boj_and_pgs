import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static Set<Integer> fans = new HashSet<>();
    static boolean check = false; //경로 존재 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int index = Integer.parseInt(st.nextToken());
            fans.add(index);
        }

        dfs(1);

        if (check) {
            System.out.println("yes");
        } else {
            System.out.println("Yes");
        }

    }

    static void dfs(int start) {
        if (fans.contains(start)) {
            return;
        }

        if (graph[start].isEmpty()) {//더 이상 나갈 곳이 없다면
            check = true;
            return;
        }

        for (int next : graph[start]) {
            dfs(next);
        }
    }
}
