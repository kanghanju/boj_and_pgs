class Solution {
    private static int[] dx = {1,0,-1};
    private static int[] dy = {0,1,-1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        
        while(true) {
            triangle[x][y] = num++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx == n || ny == n || triangle[nx][ny] != 0) {
                //방향 바꾸기 
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
                
                if(nx == n || ny == n || triangle[nx][ny] != 0) break;        
            }
        
            
            x = nx;
            y = ny;
        }
        
        int[] result = new int[num - 1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        
        return result;
    }
}