import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;

    static int countLeft(int x, int y) {
        int cnt = 0;
        for (int j = y - 1; j >= 1 && map[x][j] == '*'; j--) cnt++;
        return cnt;
    }

    static int countRight(int x, int y) {
        int cnt = 0;
        for (int j = y + 1; j <= N && map[x][j] == '*'; j++) cnt++;
        return cnt;
    }

    static int countDown(int x, int y) {
        int cnt = 0;
        for (int i = x + 1; i <= N && map[i][y] == '*'; i++) cnt++;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];

        int hx = -1, hy = -1;

        boolean foundHead = false;

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();

            for (int j = 1; j <= N; j++) {
                char c = line.charAt(j - 1);
                map[i][j] = c;

                if (!foundHead && c == '*') {
                    hx = i + 1;
                    hy = j;
                    foundHead = true;
                }
            }
        }

        int leftA = countLeft(hx,hy);
        int rightA = countRight(hx, hy);

        int body = countDown(hx, hy);
        int waistEndX = hx + body;

        int leftL = countDown(waistEndX, hy - 1);
        int rightL = countDown(waistEndX, hy + 1);

        StringBuilder sb = new StringBuilder();
        sb.append(hx).append(" ").append(hy).append("\n")
                .append(leftA).append(" ").append(rightA).append(" ")
                .append(body).append(" ")
                .append(leftL).append(" ").append(rightL);

        System.out.print(sb);
    }
}
