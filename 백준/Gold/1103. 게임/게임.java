import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static boolean hasCycle;
    static final int[] dr = {-1, 1, 0, 0},
                        dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = dfs(0, 0);

        System.out.print(hasCycle ? -1 : ans);
    }

    static int dfs(int r, int c) {
        if (hasCycle) return 0;

        if (r < 0 || r >= N || c < 0 || c >= M) return 0;
        if (board[r][c] == 'H') return 0;

        if (visited[r][c]) {
            hasCycle = true;
            return 0;
        }

        if (dp[r][c] != 0) return dp[r][c];

        visited[r][c] = true;

        int k = board[r][c] - '0';
        int best = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d] * k;
            int nc = c + dc[d] * k;
            best = Math.max(best, dfs(nr, nc));
            if (hasCycle) break;
        }

        visited[r][c] = false;

        dp[r][c] = best + 1;

        return dp[r][c];
    }
}