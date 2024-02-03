import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph,answer;
    static boolean[] visited;
    static int nowNode;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n]; //주어진 인접 행렬
        answer = new int[n][n]; //정답 인접 행렬

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited,false);
            nowNode = i;
            dfs(i);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }


    }

    static void dfs(int startRow){
        for(int i = 0; i < n; i++){
            if(graph[startRow][i] == 1 && visited[i] == false){
                answer[nowNode][i] = 1;
                visited[i] = true;
                dfs(i);
            }
        }
    }

}
