import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0},
                dc = {0, 0, -1, 1};
    static boolean[][] map;
    static int[][][] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) == '0';
            }
        }

        int INF = 1_000_001;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j][0] = INF;
                visited[i][j][1] = INF;
            }
        }

        bfs();

        int ans = Math.min(visited[N - 1][M - 1][0], visited[N - 1][M - 1][1]);

        System.out.print(ans == INF ? -1 : ans);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0, 1});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0], cc = curr[1], w = curr[2], dist = curr[3];

            if (cr == N - 1 && cc == M - 1) return;

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                int nw = w;

                if (!map[nr][nc]) {
                    if (w == 1) continue;
                    nw = 1;
                }

                int ndist = dist + 1;
                if (visited[nr][nc][nw] <= ndist) continue;

                visited[nr][nc][nw] = ndist;
                q.offer(new int[] {nr, nc, nw, ndist});
            }
        }
    }
}