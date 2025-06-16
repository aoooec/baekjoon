import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_000;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K + 1][N + 1];
		// dp[i][j] -> i개의 수로 j를 만드는 방법의 수 
		for(int i = 0; i <= N; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= K; i++) {
			for(int j = 0; j <= N; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j - 1 < 0 ? 0 : j - 1] + dp[i - 1][j]) % MOD;
				}
			}
		}
		System.out.print(dp[K][N]);
	}
}
