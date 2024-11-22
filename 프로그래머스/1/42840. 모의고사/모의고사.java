import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] person1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3,2,4,2,5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 10]) {
                count[0]++;
            }
            if (answers[i] == person2[i % 8]) {
                count[1]++;
            }
            if (answers[i] == person3[i % 10]) {
                count[2]++;
            }
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                list.add(i + 1);
            }
        }

        Collections.sort(list);

        return list.stream().mapToInt(i -> i).toArray();
    }
}