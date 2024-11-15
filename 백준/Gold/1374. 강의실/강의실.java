import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //한 강의실에서 동시에 2개 이상강의 진행x -> 다른 강의실에서는 가능
    //한 강의의 종료시간과 다른강의의 시작시간 겹치는거 o

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<ClassInfo> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new ClassInfo(number, start, end));
        }

        Collections.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //현재 사용하는 강의실
        int max = 1;

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= arr.get(i).start) {
                pq.poll();
            }
            pq.offer(arr.get(i).end); //현재 강의 끝나는 시간 추가 
            max = Math.max(max, pq.size());
        }

        System.out.println(max);

    }

    static class ClassInfo implements Comparable<ClassInfo> {

        int number;
        int start;
        int end;

        ClassInfo(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }


        @Override //시작시간 기준으로 정렬
        public int compareTo(ClassInfo o) {
            if (this.start > o.start) {
                return 1;
            } else if (this.start < o.start) {
                return -1;
            } else {
                return (this.end - o.end);
            }
        }
    }
}
