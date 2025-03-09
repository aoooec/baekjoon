import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] temp;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // 1~8, N >= M
		M = Integer.parseInt(st.nextToken()); // 1~8
		temp = new int[M];
		comb(1, 0);
		System.out.print(sb.toString());
	}

	static void comb(int idx, int cnt) {
		if(cnt == M) {
			for(int n: temp) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		if(idx > N) return;
		
		for(int i = idx; i <= N; i++) {
			if(cnt == 0 || temp[cnt - 1] <= i) temp[cnt] = i;
			else continue;			
			comb(i, cnt+1);
		}
	}
}
