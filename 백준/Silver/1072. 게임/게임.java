import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = (y * 100) / x;

        if (z >= 99) {
            System.out.println("-1");
            return;
        }

        long start = 0;
        long end = (int) x;

        while (start < end) {
            long mid = (start + end) / 2; //mid만큼의 게임을 더 함

            long tmpX = x + mid;
            long tmpY = y + mid;

            long newZ = (tmpY * 100) / tmpX;

            if (newZ > z) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(end);
    }
}