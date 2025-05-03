import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static char[][] map;
    private static int[][][] dist;

    static class Node implements Comparable<Node> {
        int r, c, garbage, near;
        Node(int r, int c, int garbage, int near) {
            this.r = r;
            this.c = c;
            this.garbage = garbage;
            this.near = near;
        }
        @Override
        public int compareTo(Node o) {
            if(this.garbage == o.garbage) return this.near - o.near;
            return this.garbage - o.garbage;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int sr = -1, sc = -1, fr = -1, fc = -1;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if(map[i][j] == 'F') {
                    fr = i;
                    fc = j;
                }
            }
        }

        dist = new int[N][M][2];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE); // 더 큰 값으로 초기화
            }
        }
        dist[sr][sc][0] = 0;
        dist[sr][sc][1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sr, sc, 0, 0));
        
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            
            // 현재 위치의 최적값이 이미 더 좋은 경우 스킵
            if(tmp.garbage > dist[tmp.r][tmp.c][0] || 
               (tmp.garbage == dist[tmp.r][tmp.c][0] && tmp.near > dist[tmp.r][tmp.c][1])) {
                continue;
            }

            for(int d = 0; d < 4; d++) {
                int nr = tmp.r + dr[d];
                int nc = tmp.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                
                int gCnt = tmp.garbage;
                int nCnt = tmp.near;
                
                // S와 F 위치는 세지 않음
                if(map[nr][nc] == 'g' && map[nr][nc] != 'F') {
                    gCnt++;
                } else if(map[nr][nc] == '.' && check(nr, nc)) {
                    // 쓰레기 옆을 지나는 경우
                    nCnt++;
                }

                if(gCnt < dist[nr][nc][0] || (gCnt == dist[nr][nc][0] && nCnt < dist[nr][nc][1])) {
                    dist[nr][nc][0] = gCnt;
                    dist[nr][nc][1] = nCnt;
                    pq.add(new Node(nr, nc, gCnt, nCnt));
                }
            }
        }
        
        System.out.println(dist[fr][fc][0] + " " + dist[fr][fc][1]);
    }

    static boolean check(int r, int c) {
        // S와 F 위치는 세지 않음
        if(map[r][c] == 'S' || map[r][c] == 'F') return false;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if(map[nr][nc] == 'g') return true;
        }
        return false;
    }
}