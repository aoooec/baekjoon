import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[1 << N];
        Arrays.fill(memo, -1);

        System.out.print(dfs(0));
    }

    static int dfs(int mask) {
        if (mask == (1 << N) - 1) return 1;

        if (memo[mask] != -1) return memo[mask];

        int weight = 500;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                weight += arr[i] - K;
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) continue;

            if (weight + arr[i] - K >= 500) {
                cnt += dfs(mask | (1 << i));
            }
        }

        return memo[mask] = cnt;
    }
}