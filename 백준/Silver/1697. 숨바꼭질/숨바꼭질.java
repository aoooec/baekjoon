import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        System.out.print(bfs());
    }

    private static int bfs() {
        if(N == K) return 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int now = q.poll();
                for (int next : new int[]{now - 1, now + 1, now * 2}) {
                    if (next == K) return cnt + 1;
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
}
