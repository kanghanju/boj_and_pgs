import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean turn = true;

        while (n > 0) {
            if (n >= 3) {
                n -= 3;
            } else {
                n -= 1;
            }
            turn = !turn;
        }

        if (turn) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
