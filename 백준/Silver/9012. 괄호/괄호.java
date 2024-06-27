import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Character> stk = new Stack<>();
            String s = br.readLine();
            char[] arr = s.toCharArray();
            boolean result = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    stk.push(arr[j]);
                } else {// ')'
                    if (stk.isEmpty()) {
                        result = true;
                        break;
                    } else {
                        stk.pop();
                    }
                }
            }

            if (result) {
                System.out.println("NO");
            } else {
                if (stk.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}