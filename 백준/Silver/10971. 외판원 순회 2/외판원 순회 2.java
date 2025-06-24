import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] map;
	static int minCost, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 2~10
		map = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCost = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, i, 1, 0);
			visited[i] = false;
		}
		System.out.print(minCost);
	}
	
	static void dfs(int start, int now, int cnt, int cost) {
		if(cnt == N) {
			if(map[now][start] != 0) {
				minCost = Math.min(minCost, cost + map[now][start]);
			}
			return;
		}
		if(cost >= minCost) return;
		
		for(int i = 0; i < N; i++) {
			if(visited[i] || map[now][i] == 0) continue;
			visited[i] = true;
			dfs(start, i, cnt + 1, cost + map[now][i]);
			visited[i] = false;
		}
	}
}
