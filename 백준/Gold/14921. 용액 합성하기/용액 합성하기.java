import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 2~100000
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int left = 0;
        int right = N - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            int abs = Math.abs(sum);
            if(min > abs) {
                min = abs;
                ans = sum;
            }
            if(sum < 0) left++;
            else if(sum > 0) right--;
            else break;
        }
        System.out.print(ans);
    }
}