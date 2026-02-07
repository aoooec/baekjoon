import java.io.*;
import java.util.*;

public class Main {
    static int TOTAL = 101;
    static int[] move = new int[TOTAL];
    static boolean[] visited = new boolean[TOTAL];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < TOTAL; i++) move[i] = i;

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move[u] = v;
        }

        int ans = bfs();

        System.out.print(ans);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int cnt = curr[1];

            if (x == 100) return cnt;

            for (int i = 1; i <= 6; i++) {
                int nx = x + i;
                if (nx >= TOTAL) continue;

                nx = move[nx];

                if (visited[nx]) continue;
                q.add(new int[]{nx, cnt + 1});
                visited[nx] = true;
            }
        }

        return -1;
    }
}