class Solution {
    public int[] solution(int brown, int yellow) {
         int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0 && (yellow / i) >= i) {
                int height = i;
                int width = yellow / i;
                int borderLine = (height * 2) + (width * 2) + 4;

                if (borderLine == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }

        return answer;
    }
}