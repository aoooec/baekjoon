import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr, temp;
	private static StringBuilder sb;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // 1 ~ 8, M <= N
		M = Integer.parseInt(st.nextToken()); // 1 ~ 8
		arr = new int[N];
		visited = new boolean[N];
		temp = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.print(sb.toString());
	}

	static void perm(int cnt) {
		if(cnt == M) {
			for(int num: temp) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = arr[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}


}
