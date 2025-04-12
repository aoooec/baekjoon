import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int maxCnt;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		maxCnt = 0;
		dfs(0, 0, 1);
		System.out.print(maxCnt);
	}

	private static void dfs(int r, int c, int cnt) {
		int num = map[r][c] - 'A';
		if(visited[num]) return;
		visited[num] = true;
		maxCnt = Math.max(maxCnt, cnt);
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			dfs(nr, nc, cnt + 1);
		}
		visited[num] = false;
	}
}
