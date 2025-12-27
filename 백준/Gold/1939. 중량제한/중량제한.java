import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, w});
            edges[b].add(new int[]{a, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] best = new int[N + 1]; 
        best[start] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        pq.add(new int[]{start, best[start]});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int v = curr[0];
            int cap = curr[1];

            if (cap < best[v]) continue;

            if (v == end) {
                System.out.println(cap);
                return;
            }

            for (int[] nxt : edges[v]) {
                int to = nxt[0];
                int w = nxt[1];

                int nextCap = Math.min(cap, w);
                if (nextCap > best[to]) {
                    best[to] = nextCap;
                    pq.add(new int[]{to, nextCap});
                }
            }
        }
    }
}