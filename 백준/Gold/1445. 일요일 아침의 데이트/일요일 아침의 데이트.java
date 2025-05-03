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
        int r, c, garbage, near; // 현재 위치의 행, 열, 쓰레기를 지나온 수, 쓰레기 근처를 지나온 수
        Node(int r, int c, int garbage, int near) {
            this.r = r;
            this.c = c;
            this.garbage = garbage;
            this.near = near;
        }
        @Override
        public int compareTo(Node o) {
            // 쓰레기를 지나온 수가 같으면 근처를 지난 수가 작은 것을 상위에
            if(this.garbage == o.garbage) return this.near - o.near;
            return this.garbage - o.garbage; // 그게 아니면 쓰레기를 지나온 수가 작은 것으로 정렬
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 숲의 세로
        M = Integer.parseInt(st.nextToken()); // 가로, 3~50
        map = new char[N][M];
        int sr = -1, sc = -1, fr = -1, fc = -1; // 두 사람의 위치, 꽃의 위치를 받을 변수
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j); // 맵 채우기
                if(map[i][j] == 'S') { // 두 사람이 있는 자리인 경우
                    sr = i;
                    sc = j;
                } else if(map[i][j] == 'F') { // 꽃이 있는 자리인 경우
                    fr = i;
                    fc = j;
                }
            }
        }

        dist = new int[N][M][2]; // [0] -> 쓰레기를 지나는 수, [1] -> 쓰레기 옆을 지나는 수
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], 2500); // 최댓값으로 채우기
            }
        }
        dist[sr][sc][0] = 0;
        dist[sr][sc][1] = 0; // 현재 위치는 0
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sr, sc, 0, 0)); // 시작지점 입력
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            for(int d = 0; d < 4; d++) { // 상하좌우 네 칸 이동 가능
                int nr = tmp.r + dr[d];
                int nc = tmp.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 범위 체크
                int gCnt = tmp.garbage;
                int nCnt = tmp.near;
                if(map[nr][nc] == 'g') gCnt++;
                else if(map[nr][nc] == '.' && check(nr, nc)) nCnt++;

                // 현재 쓰레기 카운트가 기록보다 작거나,
                // 쓰레기 기록은 같은데 쓰레기 근처를 지나간 기록보다 작은 경우
                if(gCnt < dist[nr][nc][0] || (gCnt == dist[nr][nc][0] && nCnt < dist[nr][nc][1])) {
                    dist[nr][nc][0] = gCnt;
                    dist[nr][nc][1] = nCnt; // 더 작은 값으로 갱신
                    pq.add(new Node(nr, nc, gCnt, nCnt));
                }
            }
        }
        // 모든 경우를 다 돈 후, 최종적으로 꽃 좌표에 저장된 값을 출력
        sb.append(dist[fr][fc][0]).append(" ").append(dist[fr][fc][1]);
        System.out.print(sb.toString());
    }

    static boolean check(int r, int c) {
        for(int d = 0; d < 4; d++) { // 주변에 쓰레기가 있는 경우를 탐색
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 범위 체크
            if(map[nr][nc] == 'g') return true; // 쓰레기가 있는 경우
        }
        return false; // 다 탐색했지만 쓰레기가 없는 경우
    }
}