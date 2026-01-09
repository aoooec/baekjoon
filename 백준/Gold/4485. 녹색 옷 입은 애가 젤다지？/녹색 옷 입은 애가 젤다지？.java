import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int[] dr = {-1, 1, 0, 0},
                dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = dijkstra(map, N);
            sb.append("Problem ").append(tc++).append(": ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra(int[][] map, int N) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost != dist[curr.r][curr.c]) continue;

            if (curr.r == N - 1 && curr.c == N - 1) return curr.cost;

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                int nCost = curr.cost + map[nr][nc];
                if (nCost < dist[nr][nc]) {
                    dist[nr][nc] = nCost;
                    pq.offer(new Node(nr, nc, nCost));
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
