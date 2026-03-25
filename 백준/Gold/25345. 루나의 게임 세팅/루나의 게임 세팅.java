import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.readLine();

        long[][] comb = new long[N + 1][K + 1];

        for (int n = 0; n <= N; n++) {
            comb[n][0] = 1;
            for (int k = 1; k <= Math.min(n, K); k++) {
                if (k == n) comb[n][k] = 1;
                else comb[n][k] = (comb[n - 1][k - 1] + comb[n - 1][k]) % MOD;
            }
        }

        long pow = 1;
        for (int i = 0; i < K - 1; i++) {
            pow = (pow * 2) % MOD;
        }

        long ans = (comb[N][K] * pow) % MOD;

        System.out.print(ans);
    }
}