import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 10001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 1~100
        int k = Integer.parseInt(st.nextToken()); // 1~10000
        Set<Integer> set = new HashSet<>();
        int[] coins = new int[n];

        for(int i = 0, cnt = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if(set.add(coin)) {
                coins[cnt++] = coin;
            }
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int coin: coins) {
            if(coin == 0) break;
            for(int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        System.out.print(dp[k] == INF ? -1 : dp[k]);
    }
}