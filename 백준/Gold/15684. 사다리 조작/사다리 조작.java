import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, ans;
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H+2][N+2]; // 패딩 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true; // b, b+1은 연결됨 
		}
		ans = 4; 
		dfs(0, 1, 1);
		System.out.print(ans == 4 ? -1 : ans);
	}
	
	static boolean isOk() {
		for(int i = 1; i <= N; i++) {
			int pos = i; // 현재 세로선 
			for(int h = 1; h <= H; h++) {
				if(map[h][pos]) pos++; // 오른쪽 가로선 연결됨 
				else if (pos > 1 && map[h][pos - 1]) pos--; // 왼쪽 가로선 연결됨 
			}
			if(pos != i) return false; // 도달결과 시작과 같은 열이 아닐 경우 실패 
		}
		return true;
	}
	
	static void dfs(int cnt, int r, int c) {
		if(cnt >= ans) return; // 찾은 답보다 큰 경우 
		if(isOk()) { // 모든 i 열이 i 열에 도착할때 
			ans = cnt; // 정답 갱신 후 리턴 
			return;
		}
		if(cnt == 3) return; // 다음에 cnt가 4가 됨 -> 이미 초과 
		// 가로선 추가 후 dfs 재귀 
		for(int i = r; i <= H; i++) {
			// 만약 같은 행이면 -> 현재 c부터 시작
			// 아니라면 새로운 행으로 이동한것 -> 1부터 시작 
			for(int j = (i == r ? c : 1); j < N; j++) {
				// 연속 가로선 피하기 
				if(map[i][j] || map[i][j-1] || map[i][j+1]) continue;
				map[i][j] = true;
				dfs(cnt+1, i, j+2); // 연속 가로선 피하기 위해 
				map[i][j] = false;
			}
		}
	}
}
