import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        char[][] grid = new char[R][S];
        List<Point> meteor = new ArrayList<>();
        int[] meteorBottom = new int[S];
        int[] groundTop = new int[S];
        Arrays.fill(meteorBottom, -1); // 유성이 없으면 -1
        Arrays.fill(groundTop, R);
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            boolean isM = false;
            for(int j = 0; j < S; j++) {
                char c = line.charAt(j);
                grid[i][j] = c;
                if (c == 'X') {
                    meteor.add(new Point(i, j));
                    if (i > meteorBottom[j]) meteorBottom[j] = i;
                } else if (c == '#') {
                    if (i < groundTop[j]) groundTop[j] = i;
                }
            }
        }
        int fall = R;
        for (int j = 0; j < S; j++) {
            if (meteorBottom[j] == -1) continue;
            fall = Math.min(fall, groundTop[j] - meteorBottom[j] - 1);
        }
        for (Point p : meteor) {
            grid[p.x][p.y] = '.';
        }
        for (Point p : meteor) {
            grid[p.x + fall][p.y] = 'X';
        }
        StringBuilder sb = new StringBuilder(R * (S + 1));
        for (int i = 0; i < R; i++) {
            sb.append(grid[i]).append('\n');
        }
        System.out.print(sb);
    }
}
