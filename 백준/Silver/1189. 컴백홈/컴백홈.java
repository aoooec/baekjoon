import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, K, answer;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0},
                dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'T') visited[i][j] = true;
            }
        }

        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.print(answer);
    }

    static void dfs(int r, int c, int count) {
        if (count == K) {
            if (r == 0 && c == C - 1) answer++;
            return;
        }

        int need = Math.abs(r) + Math.abs(c - (C - 1));
        int remain = K - count;
        if (need > remain) return;
        if (((remain - need) & 1) == 1) return;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc, count + 1);
            visited[nr][nc] = false;
        }
    }
}
