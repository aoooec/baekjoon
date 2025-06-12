import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 1~1000
		int W = Integer.parseInt(st.nextToken()); // 1~30
		int[] tree = new int[T+1];
		int[][][] dp = new int[T+1][W+1][2];
		for(int i = 1; i <= T; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		if (tree[1] == 1) dp[1][0][0] = 1;
		if (W >= 1 && tree[1] == 2) dp[1][1][1] = 1;
		for(int t = 2; t <= T; t++) {
			for(int w = 0; w <= W; w++) {
				for(int i = 0; i <= 1; i++) {
					dp[t][w][i] = Math.max(dp[t][w][i], dp[t-1][w][i]);
					
					if(w > 0) {
						dp[t][w][i] = Math.max(dp[t][w][i], dp[t-1][w-1][1-i]);
					}
					
					if(tree[t] == i + 1) {
						dp[t][w][i]++;
					}
				}
			}
		}
		int max = 0;
		for(int w = 0; w <= W; w++) {
			for(int i = 0; i <= 1; i++) {
				max = Math.max(max, dp[T][w][i]);
			}
		}
		System.out.print(max);
 	}
}
