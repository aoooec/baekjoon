import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N, cnt;
	private static boolean[] flagCol, flagDiagL, flagDiagR;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flagCol = new boolean[N];
		flagDiagL = new boolean[2*N -1];
		flagDiagR = new boolean[2*N -1];
		dfs(0);
		System.out.print(cnt);
	}

	static void dfs(int row) {
		if(row == N) {
			cnt++;
			return;
		}
		for(int col = 0; col < N; col++) {
			if(check(row, col)) {
				flagCol[col] = true;
				flagDiagL[row+col] = true;
				flagDiagR[row-col+N-1] = true;
				dfs(row+1);
				flagCol[col] = false;
				flagDiagL[row+col] = false;
				flagDiagR[row-col+N-1] = false;
			}
		}
	}
	
	static boolean check(int row, int col) {
		if(flagCol[col]) return false;
		if(flagDiagL[row+col]) return false;
		if(flagDiagR[row-col+N-1]) return false;
		return true;
	}
}