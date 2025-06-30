import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int R, C, W, S;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'v') W++;
				else if(map[i][j] == 'o') S++;
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j] || map[i][j] == '#') continue;
				bfs(i, j);
			}
		}
		sb.append(S).append(" ").append(W);
		System.out.print(sb.toString());
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		int wolf = 0;
		int sheep = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			if(map[row][col] == 'v') wolf++;
			else if(map[row][col] == 'o') sheep++;
			for(int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] ||  map[nr][nc] == '#') continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		if(wolf >= sheep) S -= sheep;
		else W -= wolf;
	}
}
