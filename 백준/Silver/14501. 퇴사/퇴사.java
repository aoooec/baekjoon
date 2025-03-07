import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] time, profit;
	static int N, ans= 0;
	public static void main(String[] args) throws Exception {
		// 0033
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 1 ~ 15, 남은 날짜
		time = new int[N];
		profit = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		getMaxP(0, 0);
		System.out.print(ans);
	}
	
	static void getMaxP(int idx, int sum) {
		if(idx >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		
		if(idx + time[idx] <= N) {
			getMaxP(idx + time[idx], sum + profit[idx]);
		}
		
		getMaxP(idx + 1, sum);
	}
}
