import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int N;
	private static int M;
	private static int[][] map;
	private static int minDist = 10000;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 2~100
		M = Integer.parseInt(input[1]); // 2~100
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.print(bfs());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1], cnt = cur[2];
			if(r == N-1 && c == M-1) return cnt;
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc, cnt + 1});
				}
			}
		}
		return -1;
	}

}
