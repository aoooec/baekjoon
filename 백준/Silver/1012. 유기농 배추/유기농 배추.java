import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int M, N;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 1~50, 가로 길이 
			N = Integer.parseInt(st.nextToken()); // 1~50, 세로 길이 
			int K = Integer.parseInt(st.nextToken()); // 1~2500, 배추 위치 개수
			map = new int[N][M]; // map 초기화 
			visited = new boolean[N][M]; // 방문 배열 초기화 
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			} // 배추 채우기 
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) { // 방문한 적 없고, 배추가 있는 곳
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	/** 인접한 배추를 모두 방문 처리 */
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c] = true;
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll(); 
			int row = temp[0];
			int col = temp[1];
			for(int d = 0; d < 4; d++) { // 델타 탐색 
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] != 1) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
