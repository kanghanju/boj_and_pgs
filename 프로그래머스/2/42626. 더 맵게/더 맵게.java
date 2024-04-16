import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : scoville) {
            pq.offer(num);
        }

        while (pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            
            int firstScoville = pq.remove();
            int secondScoville = pq.remove();
            
            pq.offer(firstScoville + (secondScoville * 2));
            
            answer++;
        }
        
        return answer;
    }
}