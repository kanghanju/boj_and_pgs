import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {

        int score; //해당 칸의 점수
        int red; //빨간 화살표로 이동할 경우 다음 점
        int blue; //파란 화살표로 이동할 경우 다음 점
        boolean isBlue = false; //파란 점인지 여부

        public Node(int score, int red) {
            this.score = score;
            this.red = red;
        }
    }

    static Node[] map; //게임판
    static int[] step = new int[10]; //주사위 수를 기록하는 배열
    static boolean[] existCheck = new boolean[43]; //해당 칸에 다른 말이 있는지 확인하는 배열
    static int maxScore = 0;
    static int[] horse = new int[4]; //말의 위치를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new Node[43];

        for (int i = 0; i < 10; i++) {
            step[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= 40; i += 2) {
            map[i] = new Node(i, i + 2); //빨간점 루트 설정
        }

        //파란점 루트 설정
        map[10].isBlue = map[20].isBlue = map[30].isBlue = true;
        map[10].blue = 11;
        map[20].blue = 21;
        map[30].blue = 31;

        map[11] = new Node(13, 13);
        map[13] = new Node(16, 15);
        map[15] = new Node(19, 25);
        map[21] = new Node(22, 23);
        map[23] = new Node(24, 25);
        map[25] = new Node(25, 37);
        map[31] = new Node(28, 33);
        map[33] = new Node(27, 35);
        map[35] = new Node(26, 25);
        map[37] = new Node(30, 39);
        map[39] = new Node(35, 40);
        map[42] = new Node(0, 42);//도착 지점 초기화

        dfs(0, 0);
        System.out.println(maxScore);
    }

    //현재 위치와 주사위 값에 따라 이동 후 위치를 반환하는 함수
    static int move(int pos, int diceValue) {
        int currPos = pos;

        //현재 위치가 파란점일 경우
        if (map[currPos].isBlue) {
            currPos = map[currPos].blue; //다음에 파란점으로 이동
            diceValue--; //횟수 차감
        }

        //남은 주사위 값만큼 빨간 화살표를 따라 이동
        while (diceValue-- > 0) {
            currPos = map[currPos].red;

            //도착 지점에 도달하면 멈춘다
            if (currPos == 42) {
                break;
            }
        }

        return currPos;
    }

    static void dfs(int turn, int score) {
        if (turn == 10) {
            maxScore = Math.max(score, maxScore);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int currPos = horse[i]; //i+1번째 말의 위치
            if (currPos == 42) {
                continue;
            }

            int nextPos = move(currPos, step[turn]);

            //이동하려는 칸에 이미 다른 말이 있다면 건너뛴다
            if (nextPos != 42 && existCheck[nextPos]) {
                continue;
            }

            horse[i] = nextPos;
            existCheck[currPos] = false;
            existCheck[nextPos] = true;

            dfs(turn + 1, score + map[nextPos].score);

            //상태 복원 !!
            horse[i] = currPos;
            existCheck[currPos] = true;
            existCheck[nextPos] = false;
        }
    }

}
