import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N+1];
		int[] answer = new int[N+1];
		List<Integer>[] adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			indegree[b]++;
		}
		Queue<int[]> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) q.add(new int[] {i, 1});
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			answer[temp[0]] = temp[1];
			for(int sub: adj[temp[0]]) {
				if(--indegree[sub] == 0) {
					q.add(new int[] {sub, temp[1]+1});
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}