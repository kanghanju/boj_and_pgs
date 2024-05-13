import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int index = 0; index < commands.length; index++) {
            int i = commands[index][0]; //i부터
            int j = commands[index][1]; //j번째까지
            int k = commands[index][2]; //k번째에 있는 수 
            
            int result = numberOfK(array,i,j,k);
            answer[index] = result;
        }
        return answer;
    }
    
    private int numberOfK(int[] arr, int i, int j, int k) {
        int[] sliceArr = new int[j - i + 1];
        int arrIdx = 0;

        for (int index = i - 1; index < j; index++) {
            sliceArr[arrIdx] = arr[index];
            arrIdx++;
        }

        Arrays.sort(sliceArr);
        return sliceArr[k - 1];
    }
}