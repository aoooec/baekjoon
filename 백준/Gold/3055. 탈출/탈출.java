import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static int[][] affection;
	private static Queue<int[]> q = new LinkedList<int[]>();
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int ans;
	private static int startR;
	private static int startC;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // row
		C = Integer.parseInt(st.nextToken()); // col
		affection = new int[R][C];
		visited = new boolean[R][C];
		map = new char[R][C];
		startR = -1;
		startC = -1;
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '*') affection[i][j] = 1;
				if(map[i][j] == 'S') {
					startR = i;
					startC = j;
				}
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(affection[i][j] == 1) q.add(new int[] {i, j, 1});
			}
		}
		bfs();
		System.out.println(ans == 0 ? "KAKTUS" : ans);
	}

	private static void bfs() {
		Queue<int[]> q2 = new LinkedList<int[]>();
		q2.add(new int[] {startR, startC, 1});
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] water = q.poll();
				int wr = water[0];
				int wc = water[1];
				int levelW = water[2];
				for(int d = 0; d < 4; d++) {
					int nwr = wr + dr[d];
					int nwc = wc + dc[d];
					if(nwr < 0 || nwc < 0 || nwr >= R || nwc >= C || map[nwr][nwc] == 'X' || map[nwr][nwc] == 'D' || affection[nwr][nwc] != 0) continue;
					affection[nwr][nwc] = levelW+1;
					q.add(new int[] {nwr, nwc, levelW+1});
				}
			}
		}
		while(!q2.isEmpty()) {
			int[] hedge = q2.poll();
			int hr = hedge[0];
			int hc = hedge[1];
			int levelH = hedge[2];
			for(int d = 0; d < 4; d++) {
				int nhr = hr + dr[d];
				int nhc = hc + dc[d];
				if(nhr < 0 || nhc < 0 || nhr >= R || nhc >= C || map[nhr][nhc] == 'X' || visited[nhr][nhc]) continue;
				if(map[nhr][nhc] == 'D') {
					ans = levelH;
					return;
				}
				if(affection[nhr][nhc] == 0 || affection[nhr][nhc] > levelH+1) {
					visited[nhr][nhc] = true;
					q2.add(new int[] {nhr, nhc, levelH+1});
				}
			}
		}
	}
}
