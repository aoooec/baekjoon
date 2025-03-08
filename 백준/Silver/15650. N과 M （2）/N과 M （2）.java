import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		comb(0, 0, 0);
		System.out.print(sb.toString());
	}

	static void comb(int idx, int cnt, int visited) {
		if(cnt == M) {
			for(int i = 0; i < N; i++) {
				if((visited & (1<<i)) != 0) sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(idx == N) return;
		
		comb(idx+1, cnt+1, visited | (1<<idx));
		comb(idx+1, cnt, visited);
	}
}
