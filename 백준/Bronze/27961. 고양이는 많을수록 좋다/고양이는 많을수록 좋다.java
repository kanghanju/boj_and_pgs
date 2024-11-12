import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int answer = 0;
        long start = 0;

//        while (n >= 1) {
//            if (n % 2 == 0) {
//                answer += 1;
//            } else if (n == 1) {
//                answer += 1;
//            } else {
//                answer += 2;
//            }
//            n /= 2;
//        }

        while (start < n) {
            if (start == 0) {
                answer += 1;
                start = 1;
                continue;
            }

            answer += 1;
            start *= 2;
        }

        System.out.println(answer);
    }
}