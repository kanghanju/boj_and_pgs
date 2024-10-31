import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = times[0];
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2; //(최소시간 + 가장오래걸리는 시간) / 2
            long complete = 0;

            for (int judgeTime : times) {//심사대별 심사 시간
                complete += mid / judgeTime; //각 심사대별로 주어진 시간동안 몇 명을 심사할 수 있는지 -> 주어진 인원수를 최대한 심사대별로 나누는것(최소시간구할수있다)
            }
            
            if (complete >= n) {//n명보다 오버해서 심사함. 즉 시간이 남는다.
                right = mid - 1;
                answer = mid;
            } else {//다 심사를 못함
                left = mid + 1;
                //answer = mid;가 여기에 오면 안된다! 그러면 심사를 다 못한다
            }
        }

        return answer;
    }
}