import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Set<Integer> note = new HashSet<>();

            for (int j = 0; j < n; j++) {
                note.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                if (note.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb);
    }
}
