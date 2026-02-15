import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int max = a[i];
            int min = a[i];

            dp[i] = dp[i - 1];

            for (int j = i; j >= 1; j--) {
                max = Math.max(max, a[j]);
                min = Math.min(min, a[j]);
                int score = max - min;

                dp[i] = Math.max(dp[i], dp[j - 1] + score);
            }
        }

        System.out.print(dp[N]);
    }
}