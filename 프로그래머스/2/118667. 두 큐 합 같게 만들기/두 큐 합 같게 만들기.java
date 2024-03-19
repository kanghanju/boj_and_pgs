import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum = 0;
        long divide = 0;
        long q1Sum = 0;
        int answer = 0;

        for (long num : queue1) {
            q1.add(num);
            sum += num;
            q1Sum += num;
        }

        for (long num : queue2) {
            q2.add(num);
            sum += num;
        }

        if (sum % 2 != 0) {
            return -1;
        }
        divide = sum / 2;
        
        int valid = q1.size() + q2.size();
        while (true) {
            if (q1Sum > (sum - q1Sum)) {//q1의 합이 q2보다 크다면
                long pollNum = q1.poll();
                q2.add(pollNum);
                q1Sum -= pollNum;
                answer++;
                valid--;
            } else if (q1Sum < (sum - q1Sum)) {
                long pollNum = q2.poll();
                q1.add(pollNum);
                q1Sum += pollNum;
                answer++;
            }

            if (q1Sum == divide) {
                return answer;
            }

            if (q1.size() == 0 || q2.size() == 0 ||valid == 0 ) {
                return -1;
            }
        }


    }
}