import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~15000
        int M = Integer.parseInt(br.readLine()); // 1~10000000
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int cnt = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == M) {
                cnt++;
                left++;
                right--;
            } else if (sum < M) left++;
            else right--;
        }
        System.out.print(cnt);
    }
}