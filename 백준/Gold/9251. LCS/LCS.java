import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int n = a.length;
        int m = b.length;
        int[] dp = new int[m + 1];
        for(int i = 1; i <= n; i++) {
            int prev = 0;
            for(int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (a[i - 1] == b[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        System.out.print(dp[m]);
    }
}
