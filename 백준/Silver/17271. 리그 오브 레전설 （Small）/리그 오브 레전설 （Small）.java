import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 1~10000
        int M = Integer.parseInt(st.nextToken()); // 2~100
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i = 1; i <= N; i++) {
            if(i >= M) dp[i] = dp[i-1] + dp[i-M];
            else dp[i] = dp[i-1];
            dp[i] %= mod;
        }
        System.out.print(dp[N]);
    }
}