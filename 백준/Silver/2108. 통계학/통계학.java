import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());//입력받을 수의 개수 n

        int[] count = new int[8001];
        double sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            arr.add(num); //숫자 추가
            sum += num; //평균을 구하기 위해 총합 계산
            count[num+4000]++; //나온 횟수 count
            max = Math.max(max,count[num+4000]);
        }

        int avg = (int)Math.round(sum/n); //산술 평균
        System.out.println(avg);

        Collections.sort(arr); //정렬

        int median = arr.get(n/2);
        System.out.println(median);

        boolean flag = false; //최빈값을 찾은건지 표시하는 플래그
        int frequentVal = 0;
        for(int i = 0; i<=8000; i++){
            if(count[i]==max && flag==true){
                frequentVal = i-4000;
                break;
            }else if(count[i] == max){
                flag = true;
                frequentVal = i-4000;
            }
        }

        System.out.println(frequentVal);
        System.out.println(arr.get(arr.size()-1)-arr.get(0));


    }
}
