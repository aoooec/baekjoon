import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30]; 
	public static void main(String[] args) throws Exception {
		// 0950-
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1~29, <=M
			int M = Integer.parseInt(st.nextToken()); // 1~29, N<=
			sb.append(comb(M,N)).append("\n");
		}
		System.out.print(sb.toString());
	}

	static int comb(int n, int r) {
		if(dp[n][r] != 0) return dp[n][r]; // 이미 갖고있는 값 -> 계산 필요 X
		if(n == r || r == 0) return 1; // 한 가지 경우의 수만 가짐 
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r); 
	}
}
