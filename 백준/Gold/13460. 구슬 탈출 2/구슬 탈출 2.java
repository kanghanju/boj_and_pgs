import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int N, M;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1}; //하,상,우,좌

    //**빨간,파란 구슬의 위치와 몇번 이동했는지 정보를 저장하는 클래스
    static class PairBeads {

        int redX;
        int redY;
        int blueX;
        int blueY;
        int count;

        public PairBeads(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        //사용자는 빨간 구슬과 파란 구슬의 위치를 모른다
        PairBeads pb = new PairBeads(0, 0, 0, 0, 0);

        //빨간 구슬과 파란 구슬 초기 위치를 찾는다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'R') {
                    pb.redX = i;
                    pb.redY = j;

                }

                if (board[i][j] == 'B') {
                    pb.blueX = i;
                    pb.blueY = j;

                }
            }
        }

        System.out.println(bfs(pb));
    }

    static int bfs(PairBeads pb) {
        Queue<PairBeads> queue = new LinkedList<>();
        queue.offer(pb); //큐 요소 추가에 실패한 경우 예외 대신 false 반환

        while (!queue.isEmpty()) {
            PairBeads beads = queue.poll();

            //10번 넘게 움직이면 return
            if (beads.count == 10) {
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int redX = beads.redX;
                int redY = beads.redY;
                int blueX = beads.blueX;
                int blueY = beads.blueY;
                boolean isRedHole = false;
                boolean isBlueHole = false;

                //**빨간 구슬을 해당 방향으로 벽과 마주칠때까지 이동시킨다
                while (true) {
                    int nextRedX = redX + dx[dir];
                    int nextRedY = redY + dy[dir];
                    if (board[nextRedX][nextRedY] == '#') {
                        break;
                    }

                    if (board[nextRedX][nextRedY] == 'O') {
                        isRedHole = true;
                        break;
                    }

                    redX = nextRedX;
                    redY = nextRedY;
                }

                //파란 구슬을 해당 방향으로 벽과 마주칠때까지 이동시킨다
                while (true) {
                    int nextBlueX = blueX + dx[dir];
                    int nextBlueY = blueY + dy[dir];
                    if (board[nextBlueX][nextBlueY] == '#') {
                        break;
                    }

                    if (board[nextBlueX][nextBlueY] == 'O') {
                        isBlueHole = true;
                        break;
                    }

                    blueX = nextBlueX;
                    blueY = nextBlueY;
                }

                if (isBlueHole) {
                    continue;//**파랑이 빠지면 실패한거지 -1return 하면 안됨, 큐에 남아있는 다른 경우의수 봐야함
                } else if (isRedHole) {
                    return beads.count + 1;
                }

                //두 구슬 위치가 그대로라면 큐에 집어넣지 않는다.
                if (beads.redX == redX && beads.redY == redY && beads.blueX == blueX
                    && beads.blueY == blueY) {
                    continue;
                }

                //**구슬이 같은 선상에 위치에 겹치는 경우 구슬이 겹치지 않도록 이동해준다
                if (redX == blueX && redY == blueY) {
                    //구슬이 아랫방향으로 움직여서 겹치는 경우
                    if (dir == 0) {
                        if (beads.redX < beads.blueX) {
                            redX--;
                        } else {
                            blueX--;
                        }
                    } else if (dir == 1) {
                        if (beads.redX > beads.blueX) {
                            redX++;
                        } else {
                            blueX++;
                        }
                    } else if (dir == 2) {
                        if (beads.redY < beads.blueY) {
                            redY--;
                        } else {
                            blueY--;
                        }
                    } else if (dir == 3) {
                        if (beads.redY < beads.blueY) {
                            blueY++;
                        } else {
                            redY++;
                        }
                    }
                }

                queue.offer(new PairBeads(redX, redY, blueX, blueY, beads.count + 1));
            }
        }

        return -1;
    }
}