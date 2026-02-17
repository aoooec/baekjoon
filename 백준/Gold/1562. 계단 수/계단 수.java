import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;
    static final int FULL = (1 << 10) - 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // len X 
        int[][] prev = new int[10][1 << 10];
        int[][] next = new int[10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            prev[i][1 << i] = 1;
        }

        for (int len = 1; len < N; len++) {
            for (int i = 0; i < 10; i++) {
                Arrays.fill(next[i], 0);
            }

            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask <= FULL; mask++) {
                    int val = prev[last][mask];
                    if (val == 0) continue;

                    if (last - 1 >= 0) {
                        int nMask = mask | (1 << (last - 1));
                        next[last - 1][nMask] = (next[last - 1][nMask] + val) % MOD;
                    }
                    if (last + 1 <= 9) {
                        int nMask = mask | (1 << (last + 1));
                        next[last + 1][nMask] = (next[last + 1][nMask] + val) % MOD;
                    }
                }
            }

            int[][] tmp = prev;
            prev = next;
            next = tmp;
        }

        long ans = 0;
        for (int last = 0; last <= 9; last++) {
            ans += prev[last][FULL];
        }

        System.out.print(ans % MOD);
    }
}