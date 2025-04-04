import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int D, W, K;
	private static int[][] film;
	private static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 전체 TC
		for (int test = 1; test <= TC; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = K;
			dfs(0, 0);
			
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int row, int count) {
		if(row == D) {
			if(test()) {
				ans = Math.min(ans, count);
			}
			return;
		}
		if(count >= ans) return;
		
		int[] temp = Arrays.copyOf(film[row], W);
		
		// 재귀
		dfs(row+1, count);
		
		fill(row, 0);
		dfs(row+1, count+1);
		
		fill(row, 1);
		dfs(row+1, count+1);
		
		film[row] = temp;
	}

	private static boolean test() {
		for(int i = 0; i < W; i++) {
			int cnt = 1;
			boolean passed = false;
			for(int j = 1; j < D; j++) {
				if(film[j][i] == film[j-1][i]) {
					cnt++;
				}
				else cnt = 1;
				if(cnt >= K) {
					passed = true;
					break;
				}
			}
			if(!passed) return false;
		}
		return true;
	}

	private static void fill(int row, int num) {
		for(int i = 0; i < W; i++) {
			film[row][i] = num;
		}
	}
}
