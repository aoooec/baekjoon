import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] p;
	private static int[] rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // 집합의 최대수 100000, 집합 개수는 n+1
		int m = Integer.parseInt(st.nextToken()); // 연산의 개수 1~10000
		p = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i <= n; i++) p[i] = i;
		for(int tc = 0; tc < m; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int comm = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); // 0~n
			int b = Integer.parseInt(st.nextToken());
			switch(comm) {
			case 0:
				int x = findSet(a);
				int y = findSet(b);
				if(x != y) union(x,y);
				break;
			case 1:
				sb.append(findSet(a) == findSet(b) ? "YES" : "NO").append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static void union(int x, int y) {
		if(rank[x] > rank[y]) p[y] = x;
		else {
			p[x] = y;
			if(rank[x] == rank[y]) rank[y]++;
		}
	}

	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
}
