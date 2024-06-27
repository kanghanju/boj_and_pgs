import java.util.*;

class Solution {
    
    static class Point {//1. 좌표 표현 클래스 
        private final long x;
        private final long y;
        
        public Point(long x,long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        //2. 모든 직선쌍에 대해서 교점 구하기 
        for(int i = 0; i < line.length - 1; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
                
                if(intersection == null) continue;
                
                points.add(intersection);
            }
        }
        
        //3. 2차원 배열의 크기 결정하기 
        //3-1. 교점 x,y좌표의 최대값, 최소값 구하기
        Point maximum = getMaximum(points);
        Point minimum = getMinimum(points);
        
        int width = (int)(maximum.x - minimum.x + 1);
        int height = (int)(maximum.y - minimum.y + 1);
        
        char[][] arr = new char[height][width]; //이게 헷갈림 
        for(char[] row : arr) {
            Arrays.fill(row,'.');
        }
        
        for(Point p : points) {//좌표를 표시(주의)
            int x = (int)(p.x - minimum.x);
            int y = (int)(maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        
        return result;
        
    }
    
    public Point intersection(long a,long b,long e,long c,long d,long f) {
        double x = (double)(b * f - e * d) / (a * d - b * c);
        double y = (double)(e * c - a * f) / (a * d - b * c);
        
        if(x % 1 != 0 || y % 1 != 0) {//자연수가 아니라면
            return null;
        }
        
        return new Point((long)x,(long)y);
    }
    
    public Point getMaximum(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x,y);
    }
    
    public Point getMinimum(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x,y);
    }
}