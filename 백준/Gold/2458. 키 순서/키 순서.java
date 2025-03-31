import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 2~500, 학생의 수
			int M = Integer.parseInt(st.nextToken()); // 0~N(N-1)/2, 키 비교 횟수
			map = new boolean[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
			}
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(map[i][k] && map[k][j]) {
							map[i][j] = true;
						}
					}
				}
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				int count = 0;
				for(int j = 1; j <= N; j++) {
					if(map[i][j]) count++;
					if(map[j][i]) count++;
				}
				if(count == N-1) ans++;
			}
			
		System.out.print(ans);
	} // end of main
} // end of class