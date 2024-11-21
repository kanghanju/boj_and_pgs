
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] dices;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        count = Integer.parseInt(br.readLine());
        dices = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            dices[i] = new ArrayList<>();
            for (int j = 0; j < input.length; j++) {
                dices[i].add(Integer.parseInt(input[j]));
            }
        }

        int answer = 0;
        for (int i = 0; i < 6; i++) {//첫번째 주사위의 아랫면 결정
            int sum = stackDice(0, i, 0);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }

    static int stackDice(int diceIdx, int bottomIdx, int sum) {
        int topIdx = pairCheck(bottomIdx);
        int max = 0;

        for (int i = 0; i < 6; i++) {//옆면에서 가장 큰 수 구하기
            if (i == bottomIdx || i == topIdx) {
                continue;
            }
            max = Math.max(max, dices[diceIdx].get(i));
        }

        sum += max;
        if (diceIdx == count - 1) {
            return sum;
        }

        //다음 주사위 쌓기
        for (int i = 0; i < 6; i++) {
            int beforeTop = dices[diceIdx].get(topIdx);
            if (dices[diceIdx + 1].get(i) == beforeTop) {
                sum = stackDice(++diceIdx, i, sum);
                break;
            }
        }

        return sum;
    }

    static int pairCheck(int n) {
        if (n == 0) {
            return 5;
        } else if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 4;
        } else if (n == 3) {
            return 1;
        } else if (n == 4) {
            return 2;
        } else {
            return 0;
        }
    }
}
