import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] score = new boolean[1001];
        ;

        score[1] = true; //sk win
        score[2] = false; //cy win
        score[3] = true;

        if (n > 3) {
            if (n % 2 == 1) {
                score[n] = true;
            }
        }

        if (score[n]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
