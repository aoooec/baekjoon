import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[] dp = new int[sum + 1];

        for (int i = 0; i < N; i++) {
            int c = cost[i];
            int m = memory[i];
            for (int j = sum; j >= c; j--) {
                dp[j] = Math.max(dp[j], dp[j - c] + m);
            }
        }

        int ans = 0;
        for (int c = 0; c <= sum; c++) {
            if (dp[c] >= M) {
                ans = c;
                break;
            }
        }

        System.out.print(ans);
    }
}