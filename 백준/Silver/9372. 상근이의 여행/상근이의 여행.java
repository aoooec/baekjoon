import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] p;
	private static List<Edge> edges;
	
	static class Edge {
		int s, e;
		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // tc 
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			edges = new ArrayList<Edge>();
			p = new int[N+1];
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x, y));
			}
			int cnt = 0;
			for(int i = 0; i < M && cnt != N-1; i++) {
				Edge temp = edges.get(i);
				int x = findSet(temp.s);
				int y = findSet(temp.e);
				if(x == y) continue;
				union(x, y);
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
}
