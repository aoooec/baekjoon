import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int e;
		int cost;

		public Edge(int e, int cost) {
			super();
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	private static int N;
	private static List<Edge>[] edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 1~1000, 컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); // 1~100000, 연결 선 수 
		
		edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == b) continue;
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		
		prim(1);
	}

	private static void prim(int start) {
		boolean[] visited = new boolean[N+1]; 
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0)); // 시작점
		
		int total = 0; 
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int v = tmp.e;
			int cost = tmp.cost;
			if(visited[v]) continue;
			visited[v] = true;
			total += cost;
			for(int i = 0; i < edges[v].size(); i++) {
				pq.add(edges[v].get(i));
			}
		}
		System.out.print(total);
	}
}
