import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Edge {
        int e;
        int weight;
        Edge(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken()); // 정점 수, 1~20000
        int E = Integer.parseInt(st.nextToken()); // 간선 수, 1~300000
        int K = Integer.parseInt(br.readLine()); // 시작 정점
        boolean[] visited = new boolean[V+1];
        int[] result = new int[V+1];
        List<Edge>[] adj = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
            result[i] = INF;
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, w));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        result[K] = 0;
        pq.add((new Edge(K, 0)));

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int end = tmp.e;
            if(!visited[end]) visited[end] = true;
            for(int i = 0; i < adj[end].size(); i++) {
                Edge next = adj[end].get(i);
                int nEnd = next.e;
                if(visited[nEnd]) continue;
                int sum = tmp.weight + next.weight;
                if(sum >= result[nEnd]) continue;
                result[nEnd] = sum;
                pq.add(new Edge(nEnd, result[nEnd]));
            }
        }
        for(int i = 1; i <= V; i++) {
            if(result[i] == INF) sb.append("INF");
            else sb.append(result[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}