import java.io.*;
import java.util.*;

public class Main {
    static class Item {
        int v; // 무게
        int c; // 만족도

        Item(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int x = 1;
            while (k > 0) {
                int m = Math.min(x, k);
                items.add(new Item(v * m, c * m));
                k -= m;
                x *= 2;
            }
        }

        int[] dp = new int[M + 1];

        for (Item item : items) {
            for (int v = M; v >= item.v; v--) {
                dp[v] = Math.max(dp[v], dp[v - item.v] + item.c);
            }
        }

        System.out.print(dp[M]);
    }
}