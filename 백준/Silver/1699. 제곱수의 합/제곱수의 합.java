import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int limit = (int) Math.sqrt(N);
        int[] sq = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            sq[i] = i * i;
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int s = sq[j];
                if (s > i) break;

                dp[i] = Math.min(dp[i], dp[i - s] + 1);
                if (dp[i] == 1) break;
            }
        }

        System.out.print(dp[N]);
    }
}