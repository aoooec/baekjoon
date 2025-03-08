import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] synergy;
	private static int ans, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 인원, 4~20, 짝수
		synergy = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		comb(0, 0, 0);
		System.out.print(ans);
	}

	static void comb(int idx, int cnt, int visited) {
		if(cnt == N/2) {
			int A = 0;
			int B = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if((visited & (1 << j)) != 0 && (visited & (1 << i)) != 0) {
						A += synergy[i][j];
					}
					else if((visited & (1 << j)) == 0 && (visited & (1 << i)) == 0) {
						B += synergy[i][j];
					}
				}
			}
			int diff = Math.abs(A - B);
			ans = Math.min(diff, ans);
			return;
		}
		if(idx == N) return;
		
		comb(idx+1, cnt+1, visited | (1<<idx));
		comb(idx+1, cnt, visited);
	}
}
