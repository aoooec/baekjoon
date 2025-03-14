import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] sour, bitter;
	static int ans = Integer.MAX_VALUE;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 1 ~ 10;
		sour = new int[N];
		bitter = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		minDiff(0, 1, 0, 0);
		System.out.print(ans);
	}

	private static void minDiff(int idx, int s, int b, int visited) {
		if(idx == N && Integer.bitCount(visited) >= 1) {
			ans = Math.min(ans, Math.abs(s - b));
			return;
		} else if (idx == N) return;
		
		minDiff(idx+1, s * sour[idx], b + bitter[idx], visited|(1<<idx));
		minDiff(idx+1, s, b, visited);
	}
}
