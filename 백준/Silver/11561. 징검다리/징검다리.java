import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            long n = sc.nextLong();
            binarySearch(n);
        }
    }

    public static void binarySearch(long n) {
        long start = 0;
//        long end = n;
        long end = (long) Math.sqrt(2 * n);
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = (mid * (mid + 1)) / 2;

            if (sum > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}