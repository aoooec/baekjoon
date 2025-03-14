import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static boolean[][] map;
	private static int N, M;
	static int ans = 64;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 8 ~ 50
		M = Integer.parseInt(input[1]); // 8 ~ 50
		map = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) == 'B' ? true : false; // Black = 1, white = 0
			}
		}
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
				findMinRepaint(i, j);
			}
		}
		System.out.print(ans);
	}

	private static void findMinRepaint(int R, int C) {
		int temp = 0;
		boolean first = map[R][C];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(map[R+i][C+j] != first) temp++;
				first = !first;
			}
			first = !first;
		}
		ans = Math.min(Math.min(64 - temp, temp), ans);
	}
}
