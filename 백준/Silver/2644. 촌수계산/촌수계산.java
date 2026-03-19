import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);
        dist[a] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == b) break;

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        System.out.print(dist[b]);
    }
}