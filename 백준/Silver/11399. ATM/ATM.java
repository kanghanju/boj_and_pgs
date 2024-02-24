import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        List<Integer> p = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int min = Integer.parseInt(st.nextToken());
            p.add(min);
        }

        Collections.sort(p);

        for(int i = 0; i < n; i++) {
            sum += p.get(i);
            ans.add(sum);
            answer += ans.get(i);
        }

        System.out.println(answer);
    }
}
