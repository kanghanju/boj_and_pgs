import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long start = times[0];//가장 짧게 걸릴때
        long end = (long) times[times.length - 1] * n; //가장 오래 걸릴때

        while (start < end) {
            long mid = (start + end) / 2; //심사 받는데 걸리는 시간 최소의 후보
            long complete = 0; //심사를 완료한 사람

            for (int judgeTime : times) {
                long judgeMaxNOP = mid / judgeTime; //각 심사위원이 주어진 최소시간동안 심사할 수 있는 인원 수
                complete += judgeMaxNOP;

                if (complete >= n) {
                    break;
                }
            }

            if (complete >= n) {//심사 완료 가능한 사람이 실제 주어진 사람수보다 많다면
                end = mid;
                answer = mid;
            } else {//심사 완료 시간이 부족하다면
                start = mid + 1;
            }

        }

        return answer;
    }
}