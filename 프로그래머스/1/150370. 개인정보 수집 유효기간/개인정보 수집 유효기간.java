import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] todayArr = today.split(".");

        int todayDate = getDate(today);

        HashMap<String, Integer> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.valueOf(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] priv = privacies[i].split(" ");

            if (getDate(priv[0]) + (termMap.get(priv[1]) * 28) <= todayDate) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
    
    static int getDate(String date) {
        String[] arr = date.split("\\.");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}