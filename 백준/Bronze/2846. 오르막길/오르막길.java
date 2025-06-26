import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int max = 0;
        for(int i = 1; i < N; i++) {
            if(nums[i] - nums[i - 1] <= 0) {
                max = Math.max(max, nums[i - 1] - nums[start]);
                start = i;
            } else if (i == N-1 && nums[i] - nums[i-1] > 0) {
                max = Math.max(max, nums[i] - nums[start]);
            }
        }
        System.out.print(max);
    }
}