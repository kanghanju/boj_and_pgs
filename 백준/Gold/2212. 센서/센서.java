import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        if (k >= n) {
            System.out.println(answer);
            System.exit(0);
        }

        int[] censors = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(censors);

        int[] dif = new int[n - 1]; //정점들 간 거리
        for (int i = 0; i < n - 1; i++) {
            dif[i] = censors[i + 1] - censors[i];
        }
        Arrays.sort(dif);

        for (int i = 0; i < n - k; i++) {
            answer += dif[i];
        }

        System.out.println(answer);
    }
}