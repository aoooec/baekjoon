import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 남은 날짜, 1~15
		int[] time = new int[N+1]; 
		int[] profit = new int[N+1];
		int[] dp = new int[N+2];
		for(int i = 1; i <= N; i++) { 
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken()); // 걸리는 시간, 1 ~ 5
			profit[i] = Integer.parseInt(st.nextToken()); // 수익, 1 ~ 1000
		} // 가능한 상담 목록 
		
		for(int i = 1; i <= N; i++) {
			if(i+time[i] <= N+1) { // 현재 날짜에서 상담을 시작하고, 퇴사 전에 상담 종료가 가능 
				// 현재까지의 최대 수익과 이번 경우를 비교했을때 더 큰 값을 취함 
				dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i]+profit[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]); // 상담을 진행하지 않은 경우에도 값을 갱신하여 기본값 아니도록 함 
		}
		
		System.out.print(dp[N+1]);
	}
}
