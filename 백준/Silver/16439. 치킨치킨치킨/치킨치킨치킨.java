import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int maxS;
	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		maxS = 0;
		getNum();
		System.out.print(maxS);
	}

	private static void getNum() {
		for(int i = 0; i < M-2; i++) {
			for(int j = i+1; j < M-1; j++) {
				if(i==j) continue;
				for(int k = j+1; k < M; k++) {
					int tmpSum = 0;
					if(i==k || j==k) continue;
					for(int x = 0; x < N; x++) {
						tmpSum += Math.max(map[x][i], Math.max(map[x][j], map[x][k]));
					}
					maxS = Math.max(maxS, tmpSum);
				}
			}
		}
	}
}
