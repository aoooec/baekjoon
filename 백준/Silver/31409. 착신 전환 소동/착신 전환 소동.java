import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[] b = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> roots = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
            if (a[i] == i) roots.add(i);
        }

        int k = roots.size();

        if (k >= 2) {
            for (int i = 0; i < k; i++) {
                int cur = roots.get(i);
                int next = roots.get((i + 1) % k);
                b[cur] = next;
            }
        } else if (k == 1) {
            int r = roots.get(0);
            int x = (r == 1 ? 2 : 1);
            b[r] = x;
        }

        sb.append(k).append('\n');
        for (int i = 1; i <= N; i++) {
            sb.append(b[i]).append(' ');
        }

        System.out.print(sb);
    }
}