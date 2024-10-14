import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int number : numbers) {
            set.add(number);
        }

        for (int element : arr) {
            if (set.contains(element)) {
                continue;
            }
            answer += element;
        }

        return answer;
    }
}