import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static class Edge implements Comparable<Edge> {
        int to;
        int time;
        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N+1];
        List<Edge>[] reverseGraph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
            reverseGraph[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time));
            reverseGraph[to].add(new Edge(from, time));
        }

        int[] go = dijkstra(graph, X);
        int[] back = dijkstra(reverseGraph, X);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, go[i] + back[i]);
        }

        System.out.print(max);
    }

    static int[] dijkstra(List<Edge>[] adj, int start) {
        int[] dist = new int[N+1]; // 거리를 담을 배열
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Edge(start, 0)); // 시작 위치

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll(); // 가장 빠른 길
            int now = tmp.to; // 도착 지점
            int time = tmp.time;

            if(dist[now] < time) continue;

            for(Edge next: adj[now]) { // 현재 점에서 갈 수 있는 다른 길
                if(dist[next.to] > dist[now] + next.time) {
                    dist[next.to] = dist[now] + next.time;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }
}