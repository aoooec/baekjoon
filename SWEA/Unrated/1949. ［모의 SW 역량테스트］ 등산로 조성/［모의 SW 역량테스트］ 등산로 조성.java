import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 가장 높은 봉우리는 5개 까지 있을 수 있음 
	static int N, K, maxH, ans; // N*N, K: 최대 공사 가능 깊이, maxH: 최대 높이, ans: 정답
	static int[][] mountain;
	static boolean[][] visited; 
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 전체 TC
		for (int test = 1; test <= TC; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxH = 0; // 1~20;
			ans = 0; // 등산로 길이 
			mountain = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					mountain[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, mountain[i][j]);
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mountain[i][j] == maxH) {
						dfs(i, j, maxH, 1, false);
					}
				}
			}
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		} 
		System.out.print(sb);
	}

	private static void dfs(int r, int c, int val, int dist, boolean isWork) {
		if(dist > ans) ans = dist;
		
		visited[r][c] = true; 
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue; 
			if(mountain[nr][nc] < val) dfs(nr, nc, mountain[nr][nc], dist+1, isWork);
			else if(!isWork && mountain[nr][nc] - K < val){
				dfs(nr, nc, val-1, dist+1, true);
			}
		}
		visited[r][c] = false;
	}
}
