import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[6][6];
        int[] dr = {-2,-2,-1,-1, 1, 1, 2, 2};
        int[] dc = {-1, 1,-2, 2,-2, 2,-1, 1};
        int sr = -1, sc = -1;
        int pr = -1, pc = -1;
        int lr = -1, lc = -1;

        boolean ok = true;
        for(int i = 0; i < 36; i++) {
            String curr =  br.readLine();
            int r = curr.charAt(0) - 'A';
            int c = curr.charAt(1) - '1';
            if(visited[r][c]) {
                ok = false;
                break;
            }
            visited[r][c] = true;
            if(i == 0) {
                sr = r;
                sc = c;
            } else {
                boolean canMove = false;
                for (int d = 0; d < 8; d++) {
                    if (pr + dr[d] == r && pc + dc[d] == c) {
                        canMove = true;
                        break;
                    }
                }
                if (!canMove) {
                    ok = false;
                    break;
                }
            }
            pr = r;
            pc = c;
            lr = r;
            lc = c;
        }
        if(ok) {
            boolean canClose = false;
            for (int d = 0; d < 8; d++) {
                if (lr + dr[d] == sr && lc + dc[d] == sc) {
                    canClose = true;
                    break;
                }
            }
            if (!canClose) ok = false;
        }
        System.out.print(ok ? "Valid" : "Invalid");
    }
}
