import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int     N = Integer.parseInt(st.nextToken()),
                S = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        boolean[] prev = new boolean[M + 1],
                  cur  = new boolean[M + 1];

        prev[S] = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arrays.fill(cur, false);
            int v = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if (!prev[j]) continue;
                if (j + v <= M) cur[j + v] = true;
                if (j - v >= 0) cur[j - v] = true;
            }
            boolean[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        for (int i = M; i >= 0; i--) {
            if (prev[i]) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
    }
}