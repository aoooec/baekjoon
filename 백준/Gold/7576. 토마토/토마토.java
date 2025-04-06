import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] box;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int M, N, cnt, level;
	private static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로 칸 
		N = Integer.parseInt(st.nextToken()); // 세로 칸, 2 ~ 1000 
		box = new int[N][M]; // 상자 배열 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) cnt++; // 아직 안 익은 토마토 개수 카운트 
			}
		}
		int ans = 0; 
		if(cnt != 0) { // 토마토가 이미 다 익어있는 경우 실행하지 않음 
			q = new LinkedList<int[]>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(box[i][j] == 1) {
						q.add(new int[] {i, j, 0});
					}; // 현재 익어있는 토마토를 큐에 추가 
				}
			}
			bfs(); // 확산 시작 
			if(cnt == 0) ans = level; // 토마토가 다 익음 -> 걸리는 일수 반환
			else ans = -1; // 다 익지 못함 -> -1 반환 
		}
		System.out.print(ans);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int row = temp[0];
			int col = temp[1];
			box[row][col] = 1; 
			if(level < temp[2]) level = temp[2]; // 레벨 값이 높아졌을 때만 갱신 
			for(int d = 0; d < 4; d++) {
				int nr = row + dr[d]; 
				int nc = col + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || box[nr][nc] != 0) continue;
				box[nr][nc] = -1;
				cnt--; // 익은 토마토 개수만큼 감소 
				q.add(new int[] {nr, nc, temp[2] + 1});
			}
		}
	}
}
