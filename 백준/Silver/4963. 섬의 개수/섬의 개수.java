import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	private static boolean[][] visited;
	private static int[][] map;
	private static int cnt, w, h;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); // 1~50
			h = Integer.parseInt(st.nextToken()); // 1~50
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
	 		}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0 <= nr && nr < h && 0 <= nc && nc < w) {
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}
}
