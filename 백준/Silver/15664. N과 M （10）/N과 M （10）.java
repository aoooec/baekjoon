import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] temp;
	static Set<String> set = new HashSet<String>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1 <= M <= N <= 8
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		perm(0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void perm(int idx, int cnt, int visited) {
		if(cnt == M) {
			StringBuilder key = new StringBuilder();
			for(int num: temp) key.append(num).append(" ");
			if(set.add(key.toString())) sb.append(key).append("\n");
			return;
		}
		if(idx >= N) return;
		
		for(int i = idx; i < N; i++) {
			if((visited & (1<<i)) != 0) continue;
			temp[cnt] = arr[i];
			perm(i+1, cnt+1, visited|(1<<i));
		}
	}
}
