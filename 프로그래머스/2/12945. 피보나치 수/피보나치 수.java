import java.util.*; 

class Solution {
    static int[] memo;

    public int solution(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo,-1);

        for (int i = 0; i <= n; i++) {
            memo[i] = fibonacci(i);
        }

        return fibonacci(n);
    }

    public int fibonacci(int num) {
        if (memo[num] != -1) {
            return memo[num];
        }

        if (num == 0 || num == 1) {
            return num;
        }

        return (fibonacci(num - 1) + fibonacci(num - 2)) % 1234567;
    }
}