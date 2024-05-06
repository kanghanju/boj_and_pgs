class Solution {
    static String[][] arr;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String result1 = convertToBinary(arr1[i],n);
            String result2 = convertToBinary(arr2[i],n);

            check(result1, i);
            check(result2, i);
        }

        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == null) {
                    s += " ";
                } else {
                    s += "#";
                }
            }

            answer[i] = s;
        }

        return answer;
    }

    private String convertToBinary(int n,int num) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }

        while (sb.length() < num) {
            sb.append("0");
        }

        return sb.reverse().toString();
    }

    private void check(String result, int row) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                arr[row][i] = "#";
            }  
        }
    }
}