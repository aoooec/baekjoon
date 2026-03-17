import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] roads = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            int next = i + roads[i] + 1;

            if (next >= N) dp[i] = 1;
            else dp[i] = dp[next] + 1;
        }

        for (int cnt : dp) {
            sb.append(cnt).append(' ');
        }

        System.out.print(sb);
    }
}