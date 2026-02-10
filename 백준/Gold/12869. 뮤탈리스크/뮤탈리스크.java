import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 60;
    static final int[][] DMG = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    static class State {
        int a, b, c;
        State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 0, b = 0, c = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        if (N >= 2) b = Integer.parseInt(st.nextToken());
        if (N >= 3) c = Integer.parseInt(st.nextToken());

        int[] sarr = sortDesc(a, b, c);
        a = sarr[0];
        b = sarr[1];
        c = sarr[2];

        int[][][] dist = new int[MAX + 1][MAX + 1][MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        Queue<State> q = new ArrayDeque<>();
        dist[a][b][c] = 0;
        q.add(new State(a, b, c));

        while (!q.isEmpty()) {
            State curr = q.poll();
            int d = dist[curr.a][curr.b][curr.c];
            if (curr.a == 0 && curr.b == 0 && curr.c == 0) {
                System.out.print(d);
                return;
            }

            for (int[] dmg : DMG) {
                int na = Math.max(0, curr.a - dmg[0]);
                int nb = Math.max(0, curr.b - dmg[1]);
                int nc = Math.max(0, curr.c - dmg[2]);

                int[] nsarr = sortDesc(na, nb, nc);
                na = nsarr[0];
                nb = nsarr[1];
                nc = nsarr[2];

                if (dist[na][nb][nc] != -1) continue;
                dist[na][nb][nc] = d + 1;
                q.add(new State(na, nb, nc));
            }
        }
    }

    static int[] sortDesc(int a, int b, int c) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b < c) {
            int t = b;
            b = c;
            c = t;
        }
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return new int[]{a, b, c};
    }
}