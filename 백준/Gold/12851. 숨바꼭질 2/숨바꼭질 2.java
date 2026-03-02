import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        long[] cnt = new long[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[N]= 0;
        cnt[N] = 1;
        q.add(N);

        int best = -1;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (best != -1 && dist[x] > best) break;

            if (x == K) {
                best = dist[x];
            }

            int[] nexts = {x - 1, x + 1, x * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;

                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    cnt[nx] = cnt[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) {
                    cnt[nx] += cnt[x];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[K]).append('\n').append(cnt[K]);

        System.out.print(sb);
    }
}