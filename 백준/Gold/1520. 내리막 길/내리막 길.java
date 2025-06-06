import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.print(dfs(1,1));
    }

    static int dfs(int r, int c) {
        if(r == M && c == N) return 1;
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 1 || nc < 1 || nr > M || nc > N) continue;
            if(map[r][c] > map[nr][nc]) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    }
}