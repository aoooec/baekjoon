import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0},
                dc = {0, 0, -1, 1};

    static class State {
        int r, c, used, dist;

        State(int r, int c, int used, int dist) {
            this.r = r;
            this.c = c;
            this.used = used;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M][K + 1];

        System.out.print(bfs());
    }

    static int bfs() {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(0, 0, 0, 1));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            State cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {

                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == '0' && !visited[nr][nc][cur.used]) {
                    visited[nr][nc][cur.used] = true;
                    q.offer(new State(nr, nc, cur.used, cur.dist + 1));
                } else if (map[nr][nc] == '1' && cur.used < K && !visited[nr][nc][cur.used + 1]) {
                    visited[nr][nc][cur.used + 1] = true;
                    q.offer(new State(nr, nc, cur.used + 1, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}