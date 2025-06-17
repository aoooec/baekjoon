import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int ans;
	static boolean isChange;
	static boolean[][] visited;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for(int i = 0; i < 12; i++) {
			String input = br.readLine();
			for(int j = 0; j < 6; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		while(true) {
			isChange = false;
			visited = new boolean[12][6];
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 6; j++) {
					if(!visited[i][j] && map[i][j] != '.') {
						bfs(i, j);	 
					}
				}
			}
			if(!isChange) break; // 터지는 뿌요가 없음 
			changeMap();
			ans++;
		}
		System.out.print(ans);
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		List<int[]> popList = new ArrayList<int[]>();
		char color = map[r][c];
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		popList.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
				if(!visited[nr][nc] && map[nr][nc] == color) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
					popList.add(new int[] {nr, nc});
				}
			}
		}
		
		if(popList.size() >= 4) {
			for(int[] pos: popList) {
				map[pos[0]][pos[1]] = '.';
			}
			isChange = true;
		}
	}
	
	static void changeMap() {
		for(int i = 0; i < 6; i++) {
			int idx = 11; 
			for(int j = 11; j >= 0; j--) {
				if(map[j][i] != '.') {
					map[idx][i] = map[j][i];
					if(idx != j) map[j][i] = '.';
					idx--;
 				}
			}
		}
	}
}
