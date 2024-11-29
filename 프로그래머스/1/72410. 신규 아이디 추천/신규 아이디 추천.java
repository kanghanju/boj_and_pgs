class Solution {
    public String solution(String newId) {
        //id는 3자 이상 15자 이하
        //알파벳 소문자,숫자,-,_,.문자만 사용 가능
        //.는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없다

        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9-_.]", "");
        newId = newId.replaceAll("[.]{2,}", ".");

        if (newId.startsWith(".")) {
            newId = newId.substring(1);
        }
        
        if (newId.endsWith(".")) {
            newId = newId.substring(0, newId.length() - 1);
        }

        if (newId.isEmpty()) {
            newId = "a";
        }

        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);

            if (newId.endsWith(".")) {
                newId = newId.substring(0, newId.length() - 1);
            }
        }

        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }
}