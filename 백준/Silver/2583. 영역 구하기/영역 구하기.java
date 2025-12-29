import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] map;
    static int[] dr = {-1, 1, 0, 0},
                dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = true;
                }
            }
        }

        int count = 0;
        List<Integer> sizes = new ArrayList<>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x]) continue;
                count++;
                sizes.add(bfs(y, x));
            }
        }

        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int s : sizes) sb.append(s).append(" ");

        System.out.print(sb);
    }

    static int bfs(int sy, int sx) {
        int size = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sy, sx});
        map[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc]) continue;
                map[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }

        return size;
    }
}
