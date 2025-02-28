import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] memo;
	static int cntM;
	static int cntR;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		fibM(N);
		fibR(N);
		sb.append(cntR).append(" ").append(cntM);
		System.out.println(sb.toString());
	}
	
	static int fibM(int n) {
		memo[1] = memo[2] = 1;
		for(int i = 3; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
			cntM++;
		}
		return memo[n];
	}
	
	static int fibR(int n) {
		if(n == 1 || n == 2) {
			cntR++;
			return 1;
		}
		return fibR(n-1) + fibR(n-2);
	}
}