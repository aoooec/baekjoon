import java.io.*;
import java.util.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0},
                        dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] np;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        np = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                np[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int cnt = countGlacier();
            if (cnt > 1) break;
            if (cnt == 0) {
                System.out.print(0);
                return;
            }

            melt();
            year++;
        }

        System.out.print(year);
    }

    static int countGlacier() {
        int cnt = 0;
        visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (np[i][j] == 0) continue;
                if (visited[i][j]) continue;

                visited[i][j] = true;
                q.add(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (visited[nr][nc] || np[nr][nc] == 0) continue;
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

                cnt++;
            }
        }

        return cnt;
    }

    static void melt() {
        int[][] sea = new int[N][M];

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (np[i][j] == 0) continue;

                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (np[nr][nc] == 0) cnt++;
                }
                sea[i][j] = cnt;
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (np[i][j] == 0) continue;
                np[i][j] = Math.max(0, np[i][j] - sea[i][j]);
            }
        }
    }
}