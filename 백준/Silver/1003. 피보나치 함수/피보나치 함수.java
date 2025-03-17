import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] dp = new Integer[41][2];
	static {
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
	}
	
	public static void main(String[] args) throws Exception {
		// 0938 - 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Integer[] answer = fibonacci(N);
			sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static Integer[] fibonacci(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
		return dp[n];
	}
}
