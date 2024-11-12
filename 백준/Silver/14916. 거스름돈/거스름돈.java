import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = -1;

        for (int fiveCoins = n / 5; fiveCoins >= 0; fiveCoins--) {
            int remainder = n - (5 * fiveCoins);

            if (remainder % 2 == 0) {
                int twoCoins = remainder / 2;
                answer = fiveCoins + twoCoins;
                break;
            }
        }

        System.out.println(answer);
    }
}