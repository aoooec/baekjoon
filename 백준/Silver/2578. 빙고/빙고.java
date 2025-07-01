import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N = 5;
	static Map<Integer, Point> map = new HashMap<Integer, Point>();
	static boolean[][] checked = new boolean[N][N];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
			}
		}
		int cnt = 0;
		a:
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				Point pos = map.get(num);
				checked[pos.x][pos.y] = true;
				cnt++;
				if(cnt >= 12 && isBingo()) break a;
			}
		}
		System.out.print(cnt);
	}
	static boolean isBingo() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			boolean col = true;
			boolean row = true;
			for(int j = 0; j < N; j++) {
				if(!checked[j][i]) col = false;
				if(!checked[i][j]) row = false;
			}
			if(col) cnt++;
			if(row) cnt++;
		}
		
		boolean diag1 = true, diag2 = true;
	    for (int i = 0; i < N; i++) {
	        if (!checked[i][i]) diag1 = false;
	        if (!checked[i][N - 1 - i]) diag2 = false;
	    }
	    if (diag1) cnt++;
	    if (diag2) cnt++;
	    	
		return cnt >= 3;
	}
}
