import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dp;
    private static int N;
    private static int maxLen, startRoom;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N]; // 방문 여부 체크
            dp = new int[N][N]; // 각 방에서 최대 이동할 수 있는 거리 저장
            maxLen = 0;
            startRoom = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) { // 방문하지 않은 경우만 탐색
                        visited[i][j] = true;
                        dfs(i, j, 1);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(startRoom).append(" ").append(maxLen).append("\n");
        }

        System.out.print(sb);
    }

    private static int dfs(int r, int c, int tempLen) {
        if (dp[r][c] != 0) return dp[r][c]; // 이미 계산된 값이면 반환

        dp[r][c] = 1; // 최소 자기 자신 포함

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (map[nr][nc] == map[r][c] + 1) { // 숫자가 정확히 +1 증가하는 경우만 이동 가능

                if (visited[nr][nc] && dp[nr][nc] != 0) {
                    // 이미 방문했고, dp 값이 있으면 최적의 경로를 바로 적용
                    dp[r][c] = dp[nr][nc] + 1;
                    break;
                } else if (visited[nr][nc]) {
                    // 이미 방문했으나 dp 값이 없으면 더 짧은 경로이므로 무시
                    continue;
                } else {
                    // 처음 방문하는 경우 DFS 탐색
                    visited[nr][nc] = true;
                    dp[r][c] = Math.max(dp[r][c], dfs(nr, nc, tempLen + 1) + 1);
                }
            }
        }

        // 최대 길이 갱신
        if (dp[r][c] > maxLen || (dp[r][c] == maxLen && map[r][c] < startRoom)) {
            maxLen = dp[r][c];
            startRoom = map[r][c];
        }

        return dp[r][c];
    }
}
