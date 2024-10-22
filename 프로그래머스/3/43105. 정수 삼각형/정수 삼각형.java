import java.util.*; 

class Solution {
    private static int[][] memo = new int[501][501];

    public int solution(int[][] triangle) {
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return max(0, 0, triangle);
    }

    private int max(int x, int y, int[][] triangle) {
        if (x == triangle.length) {
            return 0;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        return memo[x][y] =
            triangle[x][y] + Math.max(max(x + 1, y, triangle), max(x + 1, y + 1, triangle));
    }
}