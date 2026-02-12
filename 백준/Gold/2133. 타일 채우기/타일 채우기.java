import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dp[i] = (dp[i - 2] * 4) - dp[i - 4];
        }

        System.out.print(dp[N]);
    }
}