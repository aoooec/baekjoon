import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            long n = Long.parseLong(br.readLine());

            long ans = 0;
            while (n > 0) {
                n /= 5;
                ans += n;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}