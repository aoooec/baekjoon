import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[] p;
	private static int[][] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc 수
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " "); 
			int n = Integer.parseInt(st.nextToken()); // 1~1000000, 서로소 집합의 수
			int m = Integer.parseInt(st.nextToken()); // 1~1000000, 연산 개수
			p = new int[n+1];
			for(int i = 1; i <= n; i++) {
				p[i] = i;
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int com = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch(com) {
				case 0:
					union(findSet(a), findSet(b));
					break;
				case 1:
					sb.append(findSet(a) == findSet(b) ? 1 : 0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}

	private static void union(int x, int y) {
		if(x != y) p[y] = x;
	}
}
