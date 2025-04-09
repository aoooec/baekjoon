import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, L, R;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1~50, 맵 크기 
		L = Integer.parseInt(st.nextToken()); // 1~100
		R = Integer.parseInt(st.nextToken()); // 1~100
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 채우기 
		boolean isChanged = true;
		int day = 0;
		while(isChanged) {
			visited = new boolean[N][N];
			isChanged = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					if(bfs(i, j)) isChanged = true;
				}
			}
			
			if(isChanged) day++;
		}
		System.out.print(day);
	}

	private static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		List<int[]> nations = new ArrayList<int[]>();
		nations.add(new int[] {r, c});
		q.add(new int[] {r, c});
		visited[r][c] = true;
		int sum = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int row = temp[0];
			int col = temp[1];
			sum += map[row][col];
			for(int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				int diff = Math.abs(map[row][col] - map[nr][nc]);
				if(diff >= L && diff <= R) {
					q.add(new int[] {nr, nc});
					nations.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		if(nations.size() == 1) return false;
		
		int num = sum / nations.size();
		for(int[] pos: nations) {
			map[pos[0]][pos[1]] = num;
		}
		return true;
	}
}
