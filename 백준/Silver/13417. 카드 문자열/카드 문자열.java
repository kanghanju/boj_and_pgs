import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] cards = new String[n];
            ArrayDeque<Character> deque = new ArrayDeque<>();

            String input = br.readLine();
            cards = input.split(" ");
            deque.offer(cards[0].charAt(0));
            for (int j = 1; j < n; j++) {
                char card = cards[j].charAt(0);

                if (card <= deque.peekFirst()) {
                    deque.offerFirst(card);
                } else {
                    deque.offerLast(card);
                }
            }

            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
