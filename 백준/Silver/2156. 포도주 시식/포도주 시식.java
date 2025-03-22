import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		//1050 - 11:19
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 포도주 잔 개수, 1~10000
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		// arr[i]의 범위 1~ 1000
		for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.print(arr[1]);
			return;
		}
		dp[1] = arr[1];
		dp[2] = arr[1]+ arr[2];
		
		for(int i = 3; i <= n; i++) {
			// dp[i]는 2칸 전에서 왔거나, 1칸 전에서 왔음 
			// 1칸 전에서 온 경우 -> dp[i-2]를 지나지 않았음
			// 마지막 잔을 반드시 마셔야 하는건 아님
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+ arr[i], dp[i-3] + arr[i-1] + arr[i]));
		} 
		System.out.print(dp[n]);
	}
}
