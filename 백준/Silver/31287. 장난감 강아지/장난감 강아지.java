import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        String s = br.readLine();

        long[] xs = new long[N + 1];
        long[] ys = new long[N + 1];

        long x = 0;
        long y = 0;
        for (int i = 1; i <= N; i++) {
            char c = s.charAt(i - 1);
            switch (c) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'L': x--; break;
                case 'R': x++; break;
            }

            xs[i] = x;
            ys[i] = y;
        }

        long dx = xs[N];
        long dy = ys[N];

        if (dx == 0 && dy == 0) {
            System.out.print("YES");
            return;
        }

        for (int i = 1; i <= N; i++) {
            long xi = xs[i];
            long yi = ys[i];

            if (dx == 0) {
                if (xi != 0) continue;
                if (dy != 0 && (-yi) % dy == 0) {
                    long j = (-yi) / dy;
                    if (0 <= j && j < K) {
                        System.out.print("YES");
                        return;
                    }
                }
            } else if (dy == 0) {
                if (yi != 0) continue;
                if ((-xi) % dx == 0) {
                    long j = (-xi) / dx;
                    if (0 <= j && j < K) {
                        System.out.println("YES");
                        return;
                    }
                }
            } else {
                if ((-xi) % dx != 0) continue;
                if ((-yi) % dy != 0) continue;

                long jx = (-xi) / dx;
                long jy = (-yi) / dy;

                if (jx == jy && 0 <= jx && jx < K) {
                    System.out.print("YES");
                    return;
                }
            }
        }

        System.out.print("NO");
    }
}