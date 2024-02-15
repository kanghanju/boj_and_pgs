import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // 10815 숫자 카드
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        // 필요한 코드 작성
        int size = set.size();
        for(int i = 0; i < M; i++){
            set.add(arr2[i]);
            if(set.size() == size) {//카드가 있다
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }

            size = set.size();
        }
    }
}
