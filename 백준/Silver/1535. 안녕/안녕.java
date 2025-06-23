import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N];
        int[] J = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for(int i = 0; i < N; i++) {
            int[] temp = dp.clone();
            for(int hp = 100; hp >= L[i] + 1; hp--) {
                dp[hp - L[i]] = Math.max(dp[hp - L[i]], temp[hp] + J[i]);
            }
        }

        int max = 0;
        for(int i = 1; i <= 100; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}