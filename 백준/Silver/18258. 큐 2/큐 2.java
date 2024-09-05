

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    q.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (q.size() > 0) {
                        int num = q.peek();
                        q.pop();
                        sb.append(num).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        int num = q.peek();
                        sb.append(num).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
