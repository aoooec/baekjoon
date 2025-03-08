import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(0);
		System.out.print(sb.toString());
	}

	static void dfs(int cnt) {
		if(cnt == M) {
			for(int num: arr) sb.append(num).append(" "); 
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[cnt] = i;
			dfs(cnt+1);
		}
	}
}
