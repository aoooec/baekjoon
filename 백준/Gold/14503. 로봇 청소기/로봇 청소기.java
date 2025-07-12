import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0},
            dc = {0, 1, 0, -1}; // 북-동-남-서
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int[] start = new int[3]; // 시작 정보, [0] = R, [1] = C, [2] = D
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(start[0], start[1], start[2]);
        System.out.println(ans);
    }

    static void go(int row, int col, int dir) {
        if(map[row][col] == 0) { // 더러운 칸일 경우
            map[row][col] = -1; // 청소 처리
            ans++; // 청소 횟수 증가
        }
        for(int d = 0; d < 4; d++) {
            int nextD = (dir - d + 3) % 4;
            int nr = row + dr[nextD];
            int nc = col + dc[nextD];
            // 범위를 벗어나면 건너뛰기
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if(map[nr][nc] == 0) { // 청소 가능한 칸
                go(nr, nc, nextD);
                return; // 다른 칸으로 청소하러 갔으므로 더이상 다른 방향으로의 탐색을 진행하지 않음
            }
        }
        // 청소하러 이동하지 않은 경우
        int backD = (dir + 2) % 4;
        int nr = row + dr[backD];
        int nc = col + dc[backD];
        // 범위를 벗어났거나 벽일 경우 종료
        if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1) return;
        go(nr, nc, dir); // 아니면 방향을 유지한 채 후진
    }
}