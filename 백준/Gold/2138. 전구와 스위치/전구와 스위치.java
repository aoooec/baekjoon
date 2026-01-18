import java.io.*;
import java.util.*;

public class Main {
    static void toggle(char[] a, int idx) {
        a[idx] = a[idx] == '0' ? '1' : '0';
    }

    static int solve(char[] start, char[] target, boolean pressFirst) {
        int n = start.length;
        char[] cur = start.clone();
        int cnt = 0;

        if (pressFirst) {
            cnt++;
            toggle(cur, 0);
            toggle(cur, 1);
        }

        for (int i = 1; i < n; i++) {
            if (cur[i - 1] != target[i - 1]) {
                cnt++;
                toggle(cur, i - 1);
                toggle(cur, i);
                if (i + 1 < n) toggle(cur, i + 1);
            }
        }

        if (Arrays.equals(cur, target)) return cnt;
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] start = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int a = solve(start, target, false);
        int b = solve(start, target, true);

        int ans = Math.min(a, b);
        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
