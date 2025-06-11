import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, ans = -1;
	static int[][] map;	
	static boolean isFound = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N+1];  
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		for (int i = 0; i <= 3; i++) {
		    dfs(0, i, 1, 1);
		    if (isFound) {
		        ans = i;
		        break;
		    }
		}
		System.out.print(ans);
	}
	
	static boolean isOk() {
		for(int i = 1; i <= N; i++) {
			int pos = i; // 현재 세로선 
			for(int h = 1; h <= H; h++) {
				if(map[h][pos] == 1) pos++; // 오른쪽 가로선 연결됨 
				else if (map[h][pos] == -1) pos--; // 왼쪽 가로선 연결됨 
			}
			if(pos != i) return false; // 도달결과 시작과 같은 열이 아닐 경우 실패 
		}
		return true;
	}
	
	static void dfs(int cnt, int limit, int x, int y) {
		if(isFound) return;
		
		if (cnt == limit) {
	        if (isOk()) {
	            isFound = true;
	        }
	        return;
	    }
		
		// 가로선 추가 후 dfs 재귀 
		for (int i = x; i <= H; i++, y = 1) {
            for (int j = y; j < N; j++) {
                if (map[i][j] != 0 || map[i][j + 1] != 0) continue;

                // 인접 가로선 방지
                map[i][j] = 1;
                map[i][j + 1] = -1;
                dfs(cnt + 1, limit, i, j + 2);
                map[i][j] = 0;
                map[i][j + 1] = 0;
            }
        }
	}
	
}
