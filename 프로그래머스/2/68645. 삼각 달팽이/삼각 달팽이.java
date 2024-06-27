class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1; //채워넣을 숫자
        int x = 0;
        int y = 0; //숫자를 넣을 위치

        while (true) {//이동할 수 없을 때까지 채우기
            //아래로 이동
            while (true) {
                triangle[x][y] = v++;
                if (x == n - 1 || triangle[x + 1][y] != 0) {
                    break;
                }
                x++;
            }
            if ( y + 1 == n || triangle[x][y + 1] != 0 ) {
                break;
            }
            y += 1;

            //오른쪽으로 이동
            while (true) {
                triangle[x][y] = v++;
                if (y == n - 1 || triangle[x][y + 1] != 0) {
                    break;
                }
                y++;
            }
            if (triangle[x - 1][y - 1] != 0) {
                break;
            }
            x -= 1;
            y -= 1;

            //왼쪽 위로 이동
            while (true) {
                triangle[x][y] = v++;
                if (triangle[x - 1][y - 1] != 0) {
                    break;
                }
                x -= 1;
                y -= 1;
            }
            if ( x + 1 == n || triangle[x + 1][y] != 0) {
                break;
            }
            x++; //방향 바꾸기
        }

        int[] result = new int[v - 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}