import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int r;
        int c;
        int dist;
        public Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            if(this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }
    }
    static int N, time, Sr, Sc, baby, eatCnt;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0},
            dc = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        baby = 2;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    Sr = i;
                    Sc = j;
                    map[i][j] = 0;
                }
            }
        }
        bfs(Sr, Sc);
        System.out.print(time);
    }

    static void bfs(int Sr, int Sc) {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{Sr, Sc, 0});
        visited = new boolean[N][N];
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int d = 0; d < 4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] > baby) continue;
                visited[nr][nc] = true;
                if(map[nr][nc] != 0 && map[nr][nc] < baby) {
                    pq.add(new Fish(nr, nc, tmp[2] + 1));
                }
                q.add(new int[] {nr, nc, tmp[2] + 1});
            }
        }
        if(pq.isEmpty()) return;
        Fish fish = pq.poll();
        time += fish.dist;
        if(++eatCnt == baby) {
            baby++;
            eatCnt = 0;
        }
        map[fish.r][fish.c] = 0;
        bfs(fish.r, fish.c);
    }
}