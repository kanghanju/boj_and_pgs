import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];

        int[] dp = new int[n+1];//dp[i]는 a[i]를 마지막으로 골랐을 때 최장 증가 부분 수열의 길이다.

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; //모든수의 가장 긴 증가 부분수열의 길이 최솟값이 1이다.
        }


        int max = 1;//가장 긴 증가 부분수열의 길이 max
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(a[i] > a[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}
