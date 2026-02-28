import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;

    static class Edge {
        int from, to, w;

        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    updated = true;
                }
            }

            if (!updated) break;
        }

        for (Edge e : edges) {
            if (dist[e.from] == INF) continue;
            if (dist[e.from] + e.w < dist[e.to]) {
                System.out.print("-1");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
        }

        System.out.print(sb);
    }
}