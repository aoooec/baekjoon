
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, white, blue;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		// 0655
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0, N-1, N-1);
		System.out.println(white);
		System.out.println(blue);
		
	}

	private static void divide(int sr, int sc, int er, int ec) {
		
		int first = map[sr][sc];
		if(sr == er) {
			if(first == 1) blue++;
			else white++;
			return;
		}
		int mid = (sr + er) / 2;
		for(int i = sr; i <= er; i++) {
			for(int j = sc; j <= ec; j++) {
				if(first != map[i][j]) {
					int midR = (sr + er) / 2;
	                int midC = (sc + ec) / 2;
	                
					divide(sr, sc, midR, midC);
					divide(sr, midC+1, midR, ec);
					divide(midR+1, sc, er, midC);
					divide(midR+1, midC+1, er, ec);
					return;
				}
			}
		}
		if(first == 1) blue++;
		else white++;
	}
}
