import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long d = y - x;

            long n = (long)Math.sqrt(d);
            while ((n + 1) * (n + 1) <= d) n++;
            while (n * n > d) n--;

            long ans;
            if (d == n * n) ans = 2 * n - 1;
            else if (d <= n * n + n) ans = 2 * n;
            else ans = 2 * n + 1;

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}