import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		public int s, e, dist;

		public Edge(int s, int e, int dist) {
			this.s = s;
			this.e = e;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
		
	}

	private static List<Edge> edges;
	private static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); // 1 ~ 200000; 집의 수 
			int n = Integer.parseInt(st.nextToken()); // 1 ~ 200000; 길의 수 
			if(m == 0 && n == 0) break; // 입력 종료 
			
			p = new int[m];
			edges = new ArrayList<Edge>();
			
			for(int i = 1; i < m; i++) {
				p[i] = i;
			}
			int sum = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x, y, z));
				sum += z;
			}
			
			Collections.sort(edges);
			
			int cnt = 0;
			int minSum = 0;
			for(int i = 0; i < n && cnt != m-1; i++) {
				Edge temp = edges.get(i);
				int x = findSet(temp.s);
				int y = findSet(temp.e);
				if(x!=y) {
					union(x, y);
					cnt++;
					minSum += temp.dist;
				}
			}
			
			sb.append(sum - minSum).append("\n");
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
