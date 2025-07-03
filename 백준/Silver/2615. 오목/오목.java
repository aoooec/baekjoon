import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];
    static int[][] directions = {
            {0, 1},
            {1, 0},
            {1, 1},
            {-1, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board[x][y] != 0) {
                    int color = board[x][y];
                    for (int[] dir : directions) {
                        int count = 1;
                        int nx = x + dir[0];
                        int ny = y + dir[1];

                        while (isInBounds(nx, ny) && board[nx][ny] == color) {
                            count++;
                            if (count > 5) break;
                            nx += dir[0];
                            ny += dir[1];
                        }

                        if (count == 5) {
                            int px = x - dir[0];
                            int py = y - dir[1];
                            int ex = x + dir[0] * 5;
                            int ey = y + dir[1] * 5;

                            if ((isInBounds(px, py) && board[px][py] == color) ||
                                    (isInBounds(ex, ey) && board[ex][ey] == color)) {
                                continue;
                            }

                            sb.append(color).append("\n").append(x + 1).append(" ").append(y + 1);
                            System.out.print(sb.toString());
                            return;
                        }
                    }
                }
            }
        }
        System.out.print(0);
    }

    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}