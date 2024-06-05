class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        long pStr = Long.parseLong(p);

        for (int i = 0; i < tLen - pLen + 1; i++) {
            String str = t.substring(i, i + pLen);

            Long tStr = Long.parseLong(str);
            
            if (pStr >= tStr) {
                answer++;
            }
        }

        return answer;
    }
}