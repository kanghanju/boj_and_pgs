import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        //보드 초기화
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    //map: 현재 보드 상태
    public static void dfs(int depth, int[][] map) {
        if (depth == 5) {
            findMax(map); //현재 보드에서 최대값을 찾는다
            return;
        }

        for (int dir = 0; dir < 4; dir++) {//상하좌우 네 방향으로 보드안의 요소를 이동시킨다
            int[][] newMap = move(dir, map);
            dfs(depth + 1, newMap);
        }
    }

    //보드를 특정 방향으로 이동시키는 메서드
    public static int[][] move(int dir, int[][] map) {
        int[][] newMap = new int[N][N];
        boolean[][] merged = new boolean[N][N]; //숫자가 합쳐진 이력이 있는지 체크해야한다.. 아니면 계속 합치게됨

        //깊은 복사
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone(); //newMap[i] = map[i]로 하면 참조값이 대입됨
        }

        //**방향에 따라 이동
        switch (dir) {
            case 0://위로 이동 ,, 열은 그대로 행을 이동시킨다 따라서 열은 고정시키고 행을 탐색해야함
                //내가 자주쓰는 방향은 보통 행을 고정시키고 열을 따라 이동했음
                for (int col = 0; col < N; col++) {
                    for (int row = 1; row < N; row++) {
                        if (newMap[row][col] != 0) {
                            int currentRow = row;

                            //현재 0행이 아니고 위의 숫자가 0이라면 위로 올린다
                            while (currentRow > 0 && newMap[currentRow - 1][col] == 0) {
                                newMap[currentRow - 1][col] = newMap[currentRow][col];
                                newMap[currentRow][col] = 0; //현재 위치는 0으로 바꾼다
                                currentRow--;
                            }

                            //숫자를 합칠조건이면 합친다
                            if (currentRow > 0
                                && newMap[currentRow - 1][col] == newMap[currentRow][col]
                                && !merged[currentRow - 1][col]) {
                                newMap[currentRow - 1][col] *= 2;
                                newMap[currentRow][col] = 0;
                                merged[currentRow - 1][col] = true;
                            }
                        }
                    }
                }
                break;
            case 1: //아래로 이동
                for (int col = 0; col < N; col++) {
                    for (int row = N - 2; row >= 0; row--) {
                        if (newMap[row][col] != 0) {
                            int currentRow = row;

                            //가장 아래행-1 위치에있는 행부터 자신의 아래에 있는 행이 0이면 그냥 아래로 내린다
                            while (currentRow < N - 1 && newMap[currentRow + 1][col] == 0) {
                                newMap[currentRow + 1][col] = newMap[currentRow][col];
                                newMap[currentRow][col] = 0;
                                currentRow++; //타일을 행의 끝까지 or 다른 타일이 나올때까지 밀어야해서 이런거임
                            }

                            if (currentRow < N - 1
                                && newMap[currentRow + 1][col] == newMap[currentRow][col]
                                && !merged[currentRow + 1][col]) {
                                newMap[currentRow + 1][col] *= 2;
                                newMap[currentRow][col] = 0;
                                merged[currentRow + 1][col] = true;
                            }
                        }
                    }
                }
                break;

            case 2: //왼쪽으로 이동
                for (int row = 0; row < N; row++) {
                    for (int col = 1; col < N; col++) {
                        if (newMap[row][col] != 0) {
                            int currentCol = col;

                            while (currentCol > 0 && newMap[row][currentCol - 1] == 0) {
                                newMap[row][currentCol - 1] = newMap[row][currentCol];
                                newMap[row][currentCol] = 0;
                                currentCol--;
                            }

                            if (currentCol > 0
                                && newMap[row][currentCol - 1] == newMap[row][currentCol]
                                && !merged[row][currentCol] && !merged[row][currentCol - 1]) {
                                newMap[row][currentCol - 1] *= 2;
                                newMap[row][currentCol] = 0;
                                merged[row][currentCol - 1] = true;
                            }
                        }
                    }
                }
                break;

            case 3: //오른쪽으로 이동
                for (int row = 0; row < N; row++) {
                    for (int col = N - 2; col >= 0; col--) {
                        if (newMap[row][col] != 0) {
                            int currentCol = col;

                            while (currentCol < N - 1 && newMap[row][currentCol + 1] == 0) {
                                newMap[row][currentCol + 1] = newMap[row][currentCol];
                                newMap[row][currentCol] = 0;
                                currentCol++;
                            }

                            if (currentCol < N - 1
                                && newMap[row][currentCol + 1] == newMap[row][currentCol]
                                && !merged[row][currentCol + 1]) {
                                newMap[row][currentCol + 1] *= 2;
                                newMap[row][currentCol] = 0;
                                merged[row][currentCol + 1] = true;
                            }
                        }
                    }
                }

                break;

        }

        return newMap;
    }

    //보드에서 가장 큰 값을 찾는 함수
    public static void findMax(int[][] map) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                max = Math.max(max, map[row][col]);
            }
        }
    }


}
