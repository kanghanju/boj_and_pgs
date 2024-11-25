import java.util.Scanner;

public class Main {

    static long[] dp = new long[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            padovan(n);
            System.out.println(dp[n]);
        }

    }

    public static void padovan(int n) {
        if (n < 3) {
            visited[n] = true;
            return;
        }

        for (int i = 3; i <= n; i++) {
            if (visited[i]) continue; 
            dp[i] = dp[i - 3] + dp[i - 2];
            visited[i] = true;
        }
    }
}
