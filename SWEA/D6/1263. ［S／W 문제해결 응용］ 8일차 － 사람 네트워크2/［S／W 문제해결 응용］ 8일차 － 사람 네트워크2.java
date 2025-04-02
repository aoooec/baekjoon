import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 전체 tc
		for (int test = 1; test <= t; test++) {
			int result = 999999;
			st = new StringTokenizer(br.readLine(), " "); 
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			dist = new int[N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(i == j || num == 0) dist[i][j] = 999999;
					else dist[i][j] = num;
				}
			}
			
			for(int m = 1; m <= N; m++) {
				for(int i = 1; i <= N; i++) {
					if(m == i) continue;
					for(int j = 1; j <= N; j++) {
						if(m == j || i == j) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][m] + dist[m][j]);
					}
				}
			}
			
			for(int i = 1; i <= N; i++) {
				int temp = 0;
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					temp += dist[i][j];
				}
				result = Math.min(result, temp);
			}
			
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}	