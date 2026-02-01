import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] tests = new int[T][2];

        int maxSum = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tests[i][0] = a;
            tests[i][1] = b;
            maxSum = Math.max(maxSum, a + b);
        }

        int maxK = 0; // dp를 최대 K에 맞춰 한번만 생성
        while ((long)(maxK + 1) * (maxK + 2) / 2 <= maxSum) maxK++;

        int[] totals = new int[maxK + 1]; // K까지 필요한 물감 총량
        for (int k = 1; k <= maxK; k++) totals[k] = totals[k - 1] + k;

        int[] dp = new int[maxSum + 1];
        dp[0] = 1;

        // 크기에 따른 빨간 물감 사용량 총합에 대한 경우의 수 누적합
        int[][] prefix = new int[maxK + 1][maxSum + 1];
        for (int s = 0; s <= maxSum; s++) prefix[0][s] = 1;

        for (int k = 1; k <= maxK; k++) {
            for (int r = totals[k]; r >= k; r--) {
                dp[r] += dp[r - k];
                if (dp[r] >= MOD) dp[r] -= MOD;
            }

            int acc = 0;
            for (int r = 0; r <= maxSum; r++) {
                acc += dp[r];
                if (acc >= MOD) acc -= MOD;
                prefix[k][r] = acc;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int a = tests[i][0];
            int b = tests[i][1];

            long ans = 0;
            for (int k = 1; k <= maxK; k++) {
                int total = totals[k];
                if (total > a + b) break;

                int minR = Math.max(0, total - b);
                int maxR = Math.min(total, a);

                if (minR <= maxR) {
                    int add = prefix[k][maxR];
                    if (minR > 0) {
                        add -= prefix[k][minR - 1]; // minR 미만 경우의 수 빼기
                        if (add < 0) add += MOD; // 음수 보정
                    }

                    ans += add;
                    ans %= MOD;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}