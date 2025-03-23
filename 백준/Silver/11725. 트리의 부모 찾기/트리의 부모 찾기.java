import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static int[] parents;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		parents = new int[N+1];
		list = new ArrayList[N+1];
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(list[a] == null) list[a] = new ArrayList<Integer>();
			if(list[b] == null) list[b] = new ArrayList<Integer>();
			list[a].add(b);
			list[b].add(a);
		}
		find(1); // 1은 무조건 부모 
		for(int i = 2; i <=N; i++) sb.append(parents[i]).append("\n");
		System.out.print(sb.toString());
	}

	private static void find(int num) {
		visited[num] = true;
		for(int i = 0; i < list[num].size(); i++) {
			int child = list[num].get(i);
			if(!visited[child]) {
				parents[child] = num;
				find(child);
			}
		}
	}
}
