import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set; //중복된 값이 있는지 확인
    static boolean[] visited = new boolean[7];//각 글자를 방문했는지 확인하기 위함

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);

        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    //가능한 숫자 조합을 구한다
    static void dfs(String numbers, String s, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newString = s + numbers.charAt(i);
                set.add(Integer.parseInt(newString));//String + char = String
                dfs(numbers, newString, depth + 1);
                visited[i] = false; //꼭 해줘야함!!
            }
        }
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}