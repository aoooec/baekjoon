import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int INF = 16_000_001;
    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][(1 << N)];
        for (int[] l : dp) {
            Arrays.fill(l, -1);
        }

        System.out.print(tsp(0, 1));
    }

    static int tsp(int cur, int vis) {
        if (vis == (1 << N) - 1) {
            if (cost[cur][0] > 0) return cost[cur][0];
            return INF;
        }

        if (dp[cur][vis] != -1) return dp[cur][vis];

        dp[cur][vis] = INF;

        for (int next = 0; next < N; next++) {
            if ((vis & (1 << next)) != 0 || cost[cur][next] == 0) continue;

            dp[cur][vis] = Math.min(dp[cur][vis], cost[cur][next] + tsp(next, vis | (1 << next)));
        }

        return dp[cur][vis];
    }
}