import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] best = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a >= b) continue;
            best[a][b] = Math.max(best[a][b], c);
        }

        int[] out = new int[N + 1];
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                if (best[a][b] > 0) out[a]++;
            }
        }

        int[][] to = new int[N + 1][];
        int[][] scores = new int[N + 1][];
        for (int a = 1; a <= N; a++) {
            to[a] = new int[out[a]];
            scores[a] = new int[out[a]];
            int idx = 0;
            for (int b = a + 1; b <= N; b++) {
                int c = best[a][b];
                if (c > 0) {
                    to[a][idx] = b;
                    scores[a][idx] = c;
                    idx++;
                }
            }
        }

        int[] prev = new int[N + 1];
        int[] next = new int[N + 1];
        Arrays.fill(prev, -1);
        prev[1] = 0;

        int ans = 0;

        for (int k = 1; k < M; k++) {
            Arrays.fill(next, -1);

            for (int a = 1; a <= N; a++) {
                int base = prev[a];
                if (base == -1) continue;

                int[] t = to[a];
                int[] ww = scores[a];
                for (int i = 0; i < t.length; i++) {
                    int b = t[i];
                    int val = base + ww[i];
                    next[b] = Math.max(next[b], val);
                }
            }

            if (next[N] > ans) ans = next[N];

            int[] tmp = prev;
            prev = next;
            next = tmp;
        }

        System.out.print(ans);
    }
}