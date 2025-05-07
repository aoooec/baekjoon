import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int ans;
	private static int n;
	private static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); 
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0, cnt = 0; j < m; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		int[][] dp = new int[n][m];
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					if(i == 0 || j == 0) dp[i][j] = 1;
					else {
						dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.print(max * max);
	}
}
