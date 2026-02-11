import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] weights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int w : weights) {
            boolean[] next = new boolean[sum + 1];

            for (int d = 0; d <= sum; d++) {
                if (!dp[d]) continue;

                next[d] = true;
                if (d + w <= sum)  next[d + w] = true;
                next[Math.abs(d - w)] = true;
            }

            dp = next;
        }

        int B = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > sum || !dp[num]) sb.append('N');
            else sb.append('Y');

            sb.append(' ');
        }

        System.out.print(sb);
    }
}