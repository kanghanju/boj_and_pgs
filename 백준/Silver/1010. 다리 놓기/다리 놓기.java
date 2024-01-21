import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final int[][] dp  = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());//테스트 케이스

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//서쪽마을의 사이트
            int m = Integer.parseInt(st.nextToken());//동쪽마을의 사이트

            System.out.println(combination(m,n));
        }

    }

    static int combination(int m,int n){
        if(dp[m][n]>0){
            return dp[m][n];
        }else if(m==n || n==0){
            return dp[m][n] = 1;
        }else{
            return dp[m][n] = combination(m-1,n-1) + combination(m-1,n);
        }
    }

}