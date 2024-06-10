import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] network;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerNum = Integer.parseInt(br.readLine());
        network = new boolean[computerNum + 1][computerNum + 1];
        visited = new boolean[computerNum + 1];
        int linkNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < linkNum; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            network[com1][com2] = true;
            network[com2][com1] = true;
        }

        dfs(1);

        System.out.println(count - 1);
    }

    public static void dfs(int virusCom) {
        visited[virusCom] = true;
        count++;

        for (int i = 1; i <= network.length - 1; i++) {
            if (network[virusCom][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}
