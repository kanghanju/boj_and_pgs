import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i > 0; i--) {
            while (scores[i] <= scores[i - 1]) {
                scores[i - 1]--;
                answer++;
            }
        }

        System.out.println(answer);
    }
}