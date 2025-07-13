import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visitedF, visitedJ;
    static int[] dr = {-1, 1, 0, 0},
            dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedF = new boolean[R][C];
        visitedJ = new boolean[R][C];
        int[][] time = new int[R][C];
        int jR = 0, jC = 0; // 시작 위치
        Queue<int[]> q = new ArrayDeque<int[]>();
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'J') {
                    if(i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                        System.out.print(1);
                        return;
                    }
                    jR = i;
                    jC = j;
                    continue;
                }
                if(map[i][j] == 'F') {
                    q.add(new int[]{i, j}); // 초기 화재 시작 위치 저장
                    time[i][j] = -1;
                    visitedF[i][j] = true;
                }
            }
        }
        // 화재 확산 먼저
        int count = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C || visitedF[nr][nc] || map[nr][nc] == '#') continue;
                    visitedF[nr][nc] = true;
                    time[nr][nc] = count;
                    q.add(new int[]{nr, nc});
                }
            }
            count++;
        }
        count = 1; // 시간 초기화
        int ans = -1;
        q.add(new int[]{jR, jC});
        j:
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                if(r == 0 || c == 0 || r >= R - 1 || c >= C - 1) {
                    ans = count;
                    break j;
                }
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C || visitedJ[nr][nc] || map[nr][nc] == '#') continue;
                    if(time[nr][nc] != 0 && time[nr][nc] <= count) continue; // 확산 시점보다 느리게 도착한 경우
                    visitedJ[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
            count++;
        }
        System.out.print(ans == -1 ? "IMPOSSIBLE" : ans);
    }
}