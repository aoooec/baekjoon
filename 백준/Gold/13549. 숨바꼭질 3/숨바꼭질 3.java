import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100_000;
    static final int INF = 100_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[N]= 0;
        dq.add(N);

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            if (x == K) break;

            int nx = x * 2;
            if (nx <= MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            nx = x + 1;
            if (nx <= MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }

        System.out.print(dist[K]);
    }
}