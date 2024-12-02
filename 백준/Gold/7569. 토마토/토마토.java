import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.text.Position;

public class Main {

    static int[][][] tomatoes;
    static Queue<Position> queue = new LinkedList<>();
    static int day = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int width, length, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] boxSize = br.readLine().split(" ");

        width = Integer.parseInt(boxSize[0]);
        length = Integer.parseInt(boxSize[1]);
        height = Integer.parseInt(boxSize[2]);

        tomatoes = new int[height][length][width];

        for (int z = 0; z < height; z++) {
            for (int y = 0; y < length; y++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int x = 0; x < width; x++) {
                    tomatoes[z][y][x] = Integer.parseInt(st.nextToken());
                    if (tomatoes[z][y][x] == 1) {
                        queue.add(new Position(z, y, x));
                    }
                }
            }
        }

        bfs();

        for (int z = 0; z < height; z++) {
            for (int y = 0; y < length; y++) {
                for (int x = 0; x < width; x++) {
                    if (tomatoes[z][y][x] == 0) {
                        day = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(day);

    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Position tomatoPos = queue.poll();
                int currX = tomatoPos.x;
                int currY = tomatoPos.y;
                int currZ = tomatoPos.z;

                for (int i = 0; i < 6; i++) {//전후좌우상하
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];
                    int nextZ = currZ + dz[i];

                    if (!isValid(nextX, nextY, nextZ)) {
                        continue;
                    }

                    if (tomatoes[nextZ][nextY][nextX] == -1 || tomatoes[nextZ][nextY][nextX] == 1) {
                        continue; //토마토가 없다면 패스
                    }

                    tomatoes[nextZ][nextY][nextX] = 1;
                    queue.add(new Position(nextZ, nextY, nextX));
                }
            }

            day++;
        }

        day--; //마지막에 빈큐여도 +1되므로 -1해준다
    }

    static boolean isValid(int x, int y, int z) {
        if (x < 0 || x >= width || y < 0 || y >= length || z < 0 || z >= height) {
            return false;
        }

        return true;
    }

    static class Position {

        int x;
        int y;
        int z;

        Position(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
