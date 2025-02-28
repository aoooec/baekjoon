import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.print(0);
			return;
		} else if(N == 1) {
			System.out.print(1);
			return;
		}
		long[] memo = new long[N+1];
		memo[1] = memo[2] = 1;
		for(int i = 3; i <= N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		System.out.print(memo[N]);
	}
}