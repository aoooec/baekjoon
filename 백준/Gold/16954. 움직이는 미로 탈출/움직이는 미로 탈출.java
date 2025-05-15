import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static final int SIZE = 8;
    private static final int MAX_T = 8;
    private static char[][] map = new char[SIZE][SIZE];
    private static final int[] dr = {-1, -1, -1,  0, 0, 0,  1, 1, 1};
    private static final int[] dc = {-1,  0,  1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            String line = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][][] visited = new boolean[SIZE][SIZE][MAX_T + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {7, 0, 0});
        visited[7][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];

            // 이미 t초 시점에 벽이 있는 칸이라면 버림
            if (r - t >= 0 && map[r - t][c] == '#') continue;
            // 목표 도착 여부 확인
            if (r == 0 && c == 7) {
                System.out.print(1);
                return;
            }

            // 8방향 + 제자리
            for (int d = 0; d < 9; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                int nt = Math.min(t + 1, MAX_T);

                if (nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE) continue;
                // 이동하려는 칸이 t초 시점에 벽이면 패스
                if (nr - t >= 0 && map[nr - t][nc] == '#') continue;
                // 이동하려는 칸이 t+1초 시점에 벽이면 패스
                if (nr - nt >= 0 && map[nr - nt][nc] == '#') continue;

                if (!visited[nr][nc][nt]) {
                    visited[nr][nc][nt] = true;
                    q.offer(new int[] {nr, nc, nt});
                }
            }
        }

        System.out.print(0);
    }
}
