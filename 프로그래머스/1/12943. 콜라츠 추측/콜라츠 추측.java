class Solution {
    public int solution(int num) {

        long longNum = (long) num;
        for (int i = 0; i < 500; i++) {
            if (longNum == 1) {
                return i;
            }
            longNum = longNum % 2 == 0 ? (longNum /= 2) : (longNum = longNum * 3 + 1);
        }

        return -1;
    }
}