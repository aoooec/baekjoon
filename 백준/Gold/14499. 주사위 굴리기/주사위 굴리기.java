import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, 0, -1, 1},
                 dc = {0, 1, -1, 0, 0};
    static class Dice {
        int[] dice = new int[6]; // 위, 아래, 북, 남, 서, 동
        void roll(int d) {
            // 1: 동 2: 서 3: 북 4: 남
            int[] temp = dice.clone();
            switch(d) {
                case 1:
                    dice[0] = temp[4];
                    dice[1] = temp[5];
                    dice[4] = temp[1];
                    dice[5] = temp[0];
                    break;
                case 2:
                    dice[0] = temp[5];
                    dice[1] = temp[4];
                    dice[4] = temp[0];
                    dice[5] = temp[1];
                    break;
                case 3:
                    dice[0] = temp[3];
                    dice[1] = temp[2];
                    dice[2] = temp[0];
                    dice[3] = temp[1];
                    break;
                case 4:
                    dice[0] = temp[2];
                    dice[1] = temp[3];
                    dice[2] = temp[1];
                    dice[3] = temp[0];
                    break;
            }
        }
        int getTop() {
            return dice[0];
        }
        int getBottom() {
            return dice[1];
        }
        void changeBottom(int num) {
            dice[1] = num;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 지도 세로, 가로
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); // 주사위 좌표 x, y
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 명령 개수
        Dice dice = new Dice();
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            int comm = Integer.parseInt(st.nextToken());
            int nr = x + dr[comm];
            int nc = y + dc[comm];
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            dice.roll(comm);
            if(map[nr][nc] == 0) {
                map[nr][nc] = dice.getBottom();
            } else {
                dice.changeBottom(map[nr][nc]);
                map[nr][nc] = 0;
            }
            sb.append(dice.getTop()).append("\n");
            x = nr;
            y = nc;
        }
        System.out.print(sb.toString());
    }
}