import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0843
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1~10
		int K = Integer.parseInt(st.nextToken()); // 0~N
		int ans = 1;
		for(int i = N; i > N-K; i--) {
			ans *= i;
		}
		for(int i = 2; i <= K; i++) {
			ans /= i;
		}
		System.out.print(ans);
	}
}