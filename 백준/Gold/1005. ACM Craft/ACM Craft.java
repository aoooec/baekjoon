import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//0814
		int T = Integer.parseInt(br.readLine()); // TC
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " "); 
			int N = Integer.parseInt(st.nextToken()); // 2~1000, 건물 수
			int K = Integer.parseInt(st.nextToken()); // 1~100000, 건물 건설 규칙 수 
			int[] time = new int[N+1]; // 건물 건설당 걸리는 시간 담는 배열
			List<Integer>[] adj = new ArrayList[N+1]; 
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken()); // 0~100000
				adj[i] = new ArrayList<Integer>();
			}
			int[] indegree = new int[N+1];
			int[] dp = new int[N+1];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				indegree[b]++;
			}
			int W = Integer.parseInt(br.readLine()); // 1~1000, 지어야 할 건물 수 
			Queue<Integer> q = new LinkedList<Integer>();
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(indegree[i] == 0) {
					q.add(i); 
					dp[i] = time[i];
				}
			}
			while(!q.isEmpty()) {
				int V = q.poll();
				for(int next: adj[V]) {
					dp[next] = Math.max(dp[next], dp[V] + time[next]);
					if(--indegree[next] == 0) {
						q.add(next);
					}
				}
			}
			sb.append(dp[W]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
