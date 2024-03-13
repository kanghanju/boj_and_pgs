class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int width = 0;
        int height = 0;

        for (int i = 3; i <= (sum / 2); i++) {
            if (sum % i == 0) {
                int w = Math.max(i, sum / i); //너비 후보
                int h = Math.min(i, sum / i); //높이 후보

                if ((h - 2) * (w - 2) == yellow) {
                    width = w;
                    height = h;
                }
            }
        }

        answer[0] = width;
        answer[1] = height;

        return answer;
    }
}