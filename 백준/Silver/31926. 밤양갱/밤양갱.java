
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int answer = 8;
        int count = 1;

        while (count < n) {
            count *= 2;
            answer++;
        }

        if (count > n) {
            answer--;
        }

        System.out.println(answer + 2);
    }
}
//마지막에 daldidalgo daldida / n을 생각못함