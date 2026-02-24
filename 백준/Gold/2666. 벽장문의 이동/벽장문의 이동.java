import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        int[][] prev = new int[N + 1][N + 1];
        int[][] next = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(prev[i], INF);
        }

        int open1 = Math.min(a, b);
        int open2 = Math.max(a, b);
        prev[open1][open2] = 0;

        for (int i = 0; i < M; i++) {
            int x = target[i];

            for (int left = 1; left <= N; left++) {
                Arrays.fill(next[left], INF);
            }

            for (int left = 1; left <= N; left++) {
                for (int right = left; right <= N; right++) {
                    int curr = prev[left][right];
                    if (curr == INF) continue;

                    if (x == left || x == right) {
                        next[left][right] = Math.min(next[left][right], curr);
                    } else {
                        int p = Math.min(x, right);
                        int q = Math.max(x, right);
                        next[p][q] = Math.min(next[p][q], curr + Math.abs(left - x));

                        p = Math.min(left, x);
                        q = Math.max(left, x);
                        next[p][q] = Math.min(next[p][q], curr + Math.abs(right - x));
                    }
                }
            }

            int[][] tmp = prev;
            prev = next;
            next = tmp;
        }

        int ans = INF;
        for (int left = 1; left <= N; left++) {
            for (int right = left; right <= N; right++) {
                ans = Math.min(ans, prev[left][right]);
            }
        }

        System.out.print(ans);
    }
}