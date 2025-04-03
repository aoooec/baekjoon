import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int[][] map;
	private static int N;
	private static boolean[][] visited;
	private static int maxCnt;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 맵 크기 
		map = new int[N][N];
		
		int maxh = 1;
		int minh = 101;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxh = Math.max(maxh, map[i][j]);
				minh = Math.min(minh, map[i][j]);
			}
		}
		maxCnt = 1;
		for(int h = minh; h < maxh; h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > h && !visited[i][j]) {
						bfs(i, j, h); 
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.print(maxCnt);
	}

	private static void bfs(int r, int c, int h) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true; 
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int row = temp[0];
			int col = temp[1];
			for(int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if(nr < 0 || nc < 0|| nr >= N || nc >= N || visited[nr][nc]) continue;
				if(map[nr][nc] <= h) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}  
}
