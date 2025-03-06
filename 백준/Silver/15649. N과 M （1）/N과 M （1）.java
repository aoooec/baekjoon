
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visit;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		comb(0);
		System.out.print(sb.toString());
	}
	
	static void comb(int cnt) {
		if(cnt == M) {
			for(int num: arr) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[cnt] = i+1;
				comb(cnt + 1);
				visit[i] = false;
			}
		}
	}
}
