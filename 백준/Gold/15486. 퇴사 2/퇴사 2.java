import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] time, profit, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		time = new int[N+1];
		profit = new int[N+1];
		dp = new int[N+2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		getMax();
		System.out.print(dp[N+1]);
	}

	private static void getMax() {
 		for(int i = 1; i <= N; i++) {
			if(i+time[i] <= N+1) {
				dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i]+profit[i]);
			}
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		
	} 
}
