import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<int[]>[] shortcuts = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) shortcuts[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (e > D) continue;
            if (w >= e - s) continue;

            shortcuts[s].add(new int[] {e, w});
        }

        int INF = 120_000;
        int[] dp = new int[D + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < D; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            for (int[] sc : shortcuts[i]) {
                int e = sc[0], w = sc[1];
                dp[e] = Math.min(dp[e], dp[i] + w);
            }
        }

        System.out.print(dp[D]);
    }
}