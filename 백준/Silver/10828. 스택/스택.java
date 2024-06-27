import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stk = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stk.push(num);
            } else if (order.equals("pop")) {
                if (stk.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stk.pop());
                }
            } else if (order.equals("size")) {
                System.out.println(stk.size());
            } else if (order.equals("empty")) {
                if (stk.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("top")) {
                if (stk.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stk.peek());
                }
            }
        }

    }
}