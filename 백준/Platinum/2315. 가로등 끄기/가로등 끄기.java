import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] pos = new long[N + 1];
        long[] w = new long[N + 1];
        long[] prefix = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i] = Long.parseLong(st.nextToken());
            w[i] = Long.parseLong(st.nextToken());
            prefix[i] = prefix[i - 1] + w[i];
        }

        long total = prefix[N];

        long[][][] dp = new long[N + 1][N + 1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j][0] = INF;
                dp[i][j][1] = INF;
            }
        }

        dp[M][M][0] = 0;
        dp[M][M][1] = 0;

        for (int len = 1; len <= N; len++) {
            for (int l = 1; l + len - 1 <= N; l++) {
                int r = l + len - 1;

                long off = prefix[r] - prefix[l - 1];
                long remain = total - off;

                // 왼쪽
                if (dp[l][r][0] != INF) {
                    if (l > 1) {
                        long cost = dp[l][r][0] + remain * (pos[l] - pos[l - 1]);
                        dp[l - 1][r][0] = Math.min(dp[l - 1][r][0], cost);
                    }
                    if (r < N) {
                        long cost = dp[l][r][0] + remain * (pos[r + 1] - pos[l]);
                        dp[l][r + 1][1] = Math.min(dp[l][r + 1][1], cost);
                    }
                }

                // 오른쪽
                if (dp[l][r][1] != INF) {
                    if (l > 1) {
                        long cost = dp[l][r][1] + remain * (pos[r] - pos[l - 1]);
                        dp[l - 1][r][0] = Math.min(dp[l - 1][r][0], cost);
                    }
                    if (r < N) {
                        long cost = dp[l][r][1] + remain * (pos[r + 1] - pos[r]);
                        dp[l][r + 1][1] = Math.min(dp[l][r + 1][1], cost);
                    }
                }
            }
        }

        System.out.print(Math.min(dp[1][N][0], dp[1][N][1]));
    }
}