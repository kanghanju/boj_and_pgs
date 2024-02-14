import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //정수 N이 주어진다
        int totalClaps = 0; //박수를 친 총 횟수

        for(int i = 1; i <= N; i++) {
            String number = Integer.toString(i); //int를 String으로 바꾼다

            for(int j = 0; j < number.length(); j++) {
                char c = number.charAt(j);
                if(c == '3' || c == '6' || c == '9') {
                    totalClaps++;
                }
            }
        }
        System.out.println(totalClaps);
    }
}