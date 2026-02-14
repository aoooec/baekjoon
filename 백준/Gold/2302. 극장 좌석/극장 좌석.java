import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int[] fib = new int[N + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        long ans = 1;
        int prev = 0;
        for (int i = 0; i < M; i++) {
            int len = vip[i] - prev - 1;
            ans *= fib[len];
            prev = vip[i];
        }

        int last = N - prev;
        ans *= fib[last];

        System.out.print(ans);
    }
}