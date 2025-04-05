import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static long[] dp = new long[101]; // N은 최대 100
	static {
		dp[1] = dp[2] = dp[3] = 1; // 초기식 
		for(int i = 4; i <= 100; i++) {
			dp[i] = dp[i-3] + dp[i-2]; 
		} // 미리 100까지 채우고 반환 
	} 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); 
			sb.append(dp[N]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
