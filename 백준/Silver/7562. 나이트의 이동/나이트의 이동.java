import java.io.*;
import java.util.*;

public class Main {
    static int l, goalR, goalC;
    static boolean[][] visited;

    static final int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1},
                    dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalR = Integer.parseInt(st.nextToken());
            goalC = Integer.parseInt(st.nextToken());

            int cnt = bfs(r, c);
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int r, int c) {
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curr = cur[0];
                int curc = cur[1];
                if (curr == goalR && curc == goalC) return cnt;

                for (int d = 0; d < 8; d++) {
                    int nr = curr + dr[d];
                    int nc = curc + dc[d];
                    if (nr < 0 || nr >= l || nc < 0 || nc >= l) continue;
                    if (visited[nr][nc]) continue;

                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }

            cnt++;
        }

        return cnt;
    }
}