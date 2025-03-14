import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1 ~ M ~ N ~ 7
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		perm(0);
		System.out.print(sb.toString());
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for(int num: temp) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for(int i = 0; i < N; i++) {
			if(prev == arr[i]) continue;
			temp[cnt] = arr[i];
			prev = arr[i];
			perm(cnt + 1);
		}
	}
}
