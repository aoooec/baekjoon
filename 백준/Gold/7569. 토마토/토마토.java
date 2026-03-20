import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;

    static int[] dh = {0, 0, 0, 0, 1, -1},
            dr = {1, -1, 0, 0, 0, 0},
            dc = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    box[h][r][c] = Integer.parseInt(st.nextToken());

                    if (box[h][r][c] == 1) {
                        q.offer(new int[]{h, r, c});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int h = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int d = 0; d < 6; d++) {
                int nh = h + dh[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (box[nh][nr][nc] == 0) {
                    box[nh][nr][nc] = box[h][r][c] + 1;
                    q.offer(new int[]{nh, nr, nc});
                }
            }
        }

        int max = 0;

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (box[h][r][c] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    max = Math.max(max, box[h][r][c]);
                }
            }
        }

        System.out.print(max - 1);
    }
}