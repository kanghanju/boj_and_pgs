import java.util.ArrayList;

class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    static int answer;
    public int solution(int n, int k) {
        change(n,k);
//        Collections.reverse(arr);

        String str = "";
        for(int i = arr.size() - 1; i >= 0; i--){
            str += arr.get(i);
        }

        divide(str);

        return answer;
    }

    public void change(int n, int k){
        if(n < k){//종료조건
            arr.add(Integer.toString(n));
            return;
        }

        int r = n % k;
        arr.add(Integer.toString(r));
        change(n / k, k);
    }

    public boolean getDecimal(long num){
        if(num == 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){ //?
            if(num % i == 0){
                return false;
            }
        }

        return true; //소수가 맞다
    }

    public void divide(String num){
        int start = 0;

        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '0'){
                String number = num.substring(start,i);
                start = i + 1;

                if(number.equals(""))continue;
                long getNumber = Long.parseLong(number);

                if(getDecimal(getNumber)){
                    answer++;
                }
            }else if(i == num.length() - 1){
                String number = num.substring(start,i+1);

                if(getDecimal(Long.parseLong(number))){
                    answer++;
                }
            }
        }
    }

}