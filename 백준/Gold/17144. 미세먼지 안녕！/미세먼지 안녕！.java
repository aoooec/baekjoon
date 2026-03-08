import java.io.*;
import java.util.*;

public class Main {
    static int R, C, sum;
    static int apT = -1, apB = -1;
    static int[][] before;

    static final int[] dr = {-1, 1, 0, 0},
            dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        int T = Integer.parseInt(st.nextToken()); // 총 시간

        before = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
                if (before[i][j] == -1) {
                    if (apT == -1) apT = i;
                    else apB = i;
                    continue;
                }
                sum += before[i][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int[][] after = spread();
            before = purify(after);
        }

        System.out.print(sum);
    }

    static int[][] spread() {
        int[][] after = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int x = before[i][j];
                if (x == -1 || x == 0) continue;

                int dDust = x / 5;
                if (dDust == 0) {
                    after[i][j] += x;
                    continue;
                }

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (before[nr][nc] == -1) continue;

                    after[nr][nc] += dDust;
                    cnt++;
                }
                after[i][j] += x - dDust * cnt;
            }
        }

        return after;
    }

    static int[][] purify(int[][] after) {
        sum -= after[apT - 1][0] + after[apB + 1][0];

        for (int i = apT - 1; i > 0; i--) {
            after[i][0] = after[i - 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            after[0][j] = after[0][j + 1];
        }
        for (int i = 0; i < apT; i++) {
            after[i][C - 1] = after[i + 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            after[apT][j] = after[apT][j - 1];
        }

        for (int i = apB + 1; i < R - 1; i++) {
            after[i][0] = after[i + 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            after[R - 1][j] = after[R - 1][j + 1];
        }
        for (int i = R - 1; i > apB; i--) {
            after[i][C - 1] = after[i - 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            after[apB][j] = after[apB][j - 1];
        }

        after[apT][1] = after[apB][1] = 0;
        after[apT][0] = after[apB][0] = -1;

        return after;
    }
}