import java.util.ArrayList;


class Solution {
    static char[] vowel = new char[]{'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> dict = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            dfs(String.valueOf(vowel[i]));
        }

        answer = dict.indexOf(word);

        return answer + 1;
    }

    public void dfs(String str) {
        if (str.length() == 6) {
            return;
        }

        dict.add(str);
        for (int i = 0; i < 5; i++) {
            String word = String.valueOf(vowel[i]);
            dfs(str.concat(word));
        }
    }
}