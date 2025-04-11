import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static List<Integer>[] edges;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i = 1; i <= V; i++) edges[i] = new ArrayList<Integer>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			edges[x].add(y);
			edges[y].add(x);
		}
		bfs(1);
		int cnt = 0;
		for(int i = 2; i <= V; i++) {
			if(visited[i]) cnt++;
		}
		System.out.print(cnt);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		while(!q.isEmpty()) {
			int temp = q.poll();
			visited[temp] = true;
			for(int num: edges[temp]) {
				if(visited[num]) continue;
				visited[num] = true;
				q.add(num);
			}
		}
	}
}
