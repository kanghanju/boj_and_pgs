import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long height = 0;
        long[] trees = new long[n];
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        long left = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (trees[i] - mid > 0) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= m) {
                left = mid + 1;
                height = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(height);
    }
}