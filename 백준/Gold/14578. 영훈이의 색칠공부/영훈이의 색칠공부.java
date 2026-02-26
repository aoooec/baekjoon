import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] fact = new long[N + 1];
        long[] der = new long[N + 1]; // 아무도 자기 자리에 오지 않는 경우의 수 

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        der[0] = 1;
        if (N >= 1) der[1] = 0;
        for (int i = 2; i <= N; i++) {
            der[i] = ((i - 1) * ((der[i - 1] + der[i - 2]) % MOD)) % MOD;
        }

        long ans = fact[N] * der[N] % MOD;

        System.out.print(ans);
    }
}