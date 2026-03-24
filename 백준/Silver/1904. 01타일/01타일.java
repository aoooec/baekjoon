import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 15746;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(1);
            return;
        }
        if (N == 2) {
            System.out.print(2);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.print(dp[N]);
    }
}