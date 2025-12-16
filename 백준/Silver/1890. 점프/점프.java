import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(dp[r][c] == 0) continue;
                if(r == N - 1 && c == N - 1) continue;
                int jump = map[r][c];
                int nr = r + jump, nc = c + jump;
                if(nr < N) dp[nr][c] += dp[r][c];
                if(nc < N) dp[r][nc] += dp[r][c];
            }
        }
        System.out.print(dp[N-1][N-1]);
    }
}
