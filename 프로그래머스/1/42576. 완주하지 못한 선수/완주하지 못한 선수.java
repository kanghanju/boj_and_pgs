import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String person : participant) {
            map.putIfAbsent(person, 0);
            map.put(person, map.get(person) + 1);
        }

        for (String person : completion) {
            int count = map.get(person) - 1;
            map.put(person, count);
            if (count <= 0) {
                map.remove(person);
            }
        }

        return map.keySet().iterator().next();
    }
}