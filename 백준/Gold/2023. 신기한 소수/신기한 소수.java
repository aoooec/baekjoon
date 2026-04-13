import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int[] CANDIDATES = {1, 3, 7, 9};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.print(sb);
    }

    static void dfs(int num, int len) {
        if (len == N) {
            sb.append(num).append('\n');
            return;
        }

        for (int d : CANDIDATES) {
            int next = num * 10 + d;
            if (isPrime(next)) {
                dfs(next, len + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}