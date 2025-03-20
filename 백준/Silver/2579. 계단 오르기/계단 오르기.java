import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0843-
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 계단은 한번에 한 계단 또는 두 계단씩 오를 수 있다 
		// 연속된 세개의 계단을 모두 밟아서는 안된다. 단 시작점은 계단에 포함하지 않는다.
		// 마지막 도착 계단은 반드시 밟아야 한다.
		// 얻을 수 있는 총 점수의 최댓값
		int T = Integer.parseInt(br.readLine()); // 1~300, 계단 수 
		int[] arr = new int[T+1];
		int[] dp = new int[T+1];
		for(int i = 1; i <= T; i++) arr[i] = Integer.parseInt(br.readLine());
		dp[1] = arr[1];
		if(T >= 2) dp[2] = arr[1] + arr[2];
		if(T >= 3) dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
		
		for(int i = 4; i <= T; i++) {
			dp[i] = Math.max(arr[i] + dp[i-2], arr[i] + dp[i-3] + arr[i-1]);
		}
		System.out.print(dp[T]);
	}

}
