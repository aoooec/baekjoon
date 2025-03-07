import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static int ans, N;
	private static boolean[] flagCol;
	private static boolean[] flagDiagL;
	private static boolean[] flagDiagR;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 보드의 크기, 퀸의 개수 1~10
			flagCol = new boolean[N];
			flagDiagL = new boolean[2*N - 1];
			flagDiagR = new boolean[2*N - 1];
			ans = 0; // 초기화 
			dfs(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} // end of test case 
		System.out.print(sb.toString());
	} // end of main
	
	/** row 값을 받아 퀸을 배치하는 함수 */
	static void dfs(int row) {
		if(row == N) {
			ans++;
			return; // row가 N이 되면 인덱스 범위를 넘어가므로 탐색 완료, 종료 
		}
		
		for(int col = 0; col < N; col++) { // 전체를 탐색
			// 보드의 한 열에는 퀸이 하나만 존재한다.
			// 보드의 대각선 한 줄에도 퀸은 하나만 존재해야 한다.
			// 따라서 행마다 퀸을 배열할 때, 
			// 해당 열, 대각선에 다른 퀸이 이미 배치되어있지 않은지 확인한다.
			if(check(row, col)) { // 놔도 되는 열이면 
				// 존재하지 않는다면 해당 위치에 퀸을 위치시키고, 이를 저장
				flagCol[col] = true;
				flagDiagL[row+col] = true;
				flagDiagR[row-col+N-1] = true;
				// 보드의 한 행에는 퀸이 하나만 존재한다. 
				// 따라서 한 행에 퀸을 배열했다면, 바로 다음 행으로 넘어간다. 
				dfs(row + 1); // 다음 행으로 재귀 호출 
				flagCol[col] = false; // 다른 열을 탐색하기 위해 원상복구 
				flagDiagL[row+col] = false;
				flagDiagR[row-col+N-1] = false;
			} else continue; // 만약 다른 퀸이 존재한다면, 해당 자리에 대한 탐색을 중단하고 다음 열로 이동한다. 
			
		}
	}

	/** row, col 값을 받아 이미 배치된 자리가 현재 배치 예정인 자리를 공격 가능한지 확인*/
	static boolean check(int row, int col) {
		if(flagCol[col]) return false;
		if(flagDiagL[row+col]) return false;
		if(flagDiagR[row-col+N-1]) return false;
		return true; // 해당하지 않는 경우만 true 
	}
} // end of class
