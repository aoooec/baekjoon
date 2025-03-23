import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static Map<Integer, ArrayList<Integer>> map;
	private static int[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// 1140
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수, 1~1000
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수, 1~10000
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 V
		map = new HashMap<Integer, ArrayList<Integer>>();
		visited = new int[1001];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.putIfAbsent(a, new ArrayList<Integer>());
			map.putIfAbsent(b, new ArrayList<Integer>());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		for(ArrayList<Integer> list: map.values()) {
			Collections.sort(list);
		}
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.print(sb.toString());
	}

	private static void bfs(int v) {
		visited = new int[1001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(visited[temp] == 1) continue;
			visited[temp] = 1;
			sb.append(temp).append(" ");
			if(!map.containsKey(temp)) continue;
			int size = map.get(temp).size();
			for(int i = 0; i < size; i++) {
				if(visited[map.get(temp).get(i)] != 1) q.add(map.get(temp).get(i));
			}
		}
	}

	private static void dfs(int v) {
		if(visited[v] == 1) return;
		visited[v] = 1;
		sb.append(v).append(" ");
		if(!map.containsKey(v)) return;
		for(int i = 0; i < map.get(v).size(); i++) {
			dfs(map.get(v).get(i));
		}
	}
}
