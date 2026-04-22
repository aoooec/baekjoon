import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());

            int[] files = new int[K + 1];
            long[] prefix = new long[K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + files[i];
            }

            long[][] dp = new long[K + 2][K + 2];
            int[][] opt = new int[K + 2][K + 2];

            for (int i = 1; i <= K; i++) {
                opt[i][i] = i;
            }

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Long.MAX_VALUE;

                    long sum = prefix[j] - prefix[i - 1];

                    int start = opt[i][j - 1];
                    int end = opt[i + 1][j];
                    if (end == 0) end = j - 1;

                    for (int k = start; k <= end; k++) {
                        long cost = dp[i][k] + dp[k + 1][j] + sum;
                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                            opt[i][j] = k;
                        }
                    }
                }
            }

            sb.append(dp[1][K]).append('\n');
        }

        System.out.print(sb);
    }
}