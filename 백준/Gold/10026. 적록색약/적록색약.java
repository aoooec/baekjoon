import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, nCnt, cCnt;
    private static char[][] map;
    private static boolean[][] nVisited, cVisited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); // 1~100
        map = new char[N][N];
        nVisited = new boolean[N][N];
        cVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = input.charAt(j);
                map[i][j] = c;
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!nVisited[i][j]) {
                    bfs(i, j);
                    nCnt++;
                }
                if(!cVisited[i][j]) {
                    cBfs(i, j);
                    cCnt++;
                }
            }
        }
        sb.append(nCnt).append(" ").append(cCnt);
        System.out.print(sb.toString());
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        nVisited[r][c] = true;
        char now = map[r][c];
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tr = tmp[0];
            int tc = tmp[1];
            for(int d = 0; d < 4; d++) {
                int nr = tr + dr[d];
                int nc = tc + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || nVisited[nr][nc] || map[nr][nc] != now) continue;
                nVisited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    static void cBfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        cVisited[r][c] = true;
        char now = map[r][c];
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tr = tmp[0];
            int tc = tmp[1];
            for(int d = 0; d < 4; d++) {
                int nr = tr + dr[d];
                int nc = tc + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || cVisited[nr][nc]) continue;
                if(now != map[nr][nc] && (now == 'B' || map[nr][nc] == 'B')) continue;
                cVisited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}