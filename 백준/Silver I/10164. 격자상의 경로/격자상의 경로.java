import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited;
    static int n;
    static int m;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = 1;
        int ans = 0;

        visited = new int[n][m];
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = num++;
            }
        }

        if(k == 0) {//O표시되어 있는게 없다면
            startX = 0;
            startY = 0;
            ans = move(n-1,m-1);
        }else {//O표시가 있다면
            int kX = 0;
            int kY = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == k){
                        kX = i;
                        kY = j;
                        break;
                    }
                }
            }
            ans = move(kX,kY);
//            System.out.println("kX:"+kX+",kY:"+kY);
//            System.out.println(ans);
//            print();
            startX = kX;
            startY = kY;
            ans = move(n-1,m-1);
//            print();
        }

        System.out.println(ans);
    }

    static int move(int r,int c){
        if(!isValid(r,c)){
            return 0;
        }else if(r == 0 || c == 0) {
            return visited[r][c] = 1;
        }else if(visited[r][c] > 0){
            return visited[r][c];
        }else {
            visited[r][c] = move(r,c-1) + move(r-1,c);
            return visited[r][c];
        }
    }

    static boolean isValid(int r,int c){
        return (r >= startX && r < n) && ( c >= startY && c < m);
    }

    static void print(){
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
