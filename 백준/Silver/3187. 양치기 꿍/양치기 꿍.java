import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static char[][] map;
	private static int R, C, wolf , sheep;
	private static boolean[][] visited;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken()); // 3~250 세로 
		C = Integer.parseInt(st.nextToken()); // 가로 
		map = new char[R][C]; // 원본 배열 
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) { // 원본 배열을 채우고, 양과 늑대의 총 합을 카운트
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'v') wolf++;
				else if(map[i][j] == 'k') sheep++;
			}
		}
		for(int i = 1; i < R-1; i++) { // 맨 첫줄, 끝줄은 무조건 울타리 안이 아님 
			for(int j = 1; j < C-1; j++) {
				// 미방문 위치에서 bfs 탐색 시작
				// 늑대 또는 양일때만 
				if((map[i][j] == 'v' || map[i][j] == 'k') &&!visited[i][j]) bfs(i, j);  
			}
		}
		sb.append(sheep).append(" ").append(wolf);
		System.out.print(sb.toString());
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.add(new int[] {r, c});
		int tempW = 0;
		int tempS = 0; // 이번 탐색의 임시 양, 늑대 카운트 
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int posR = pos[0];
			int posC = pos[1];
			if(map[posR][posC] == 'v') tempW++;
			else if(map[posR][posC] == 'k') tempS++;
			for(int d = 0; d < 4; d++) {
				int nr = posR + dr[d];
				int nc = posC + dc[d];
				if(nr < 1 || nc < 1 || nr >= R-1 || nc >= C-1 
						  || visited[nr][nc] || map[nr][nc] == '#') continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		if(tempW < tempS) wolf -= tempW;
		else sheep -= tempS; 
	}	
}
