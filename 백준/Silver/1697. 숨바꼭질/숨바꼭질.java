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
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int now = q.poll();
                if(now == K) return cnt;
                if(now + 1 <= 100000 && !visited[now + 1]) {
                    q.add(now + 1);
                    visited[now + 1] = true;
                }
                if(now - 1 >= 0 && !visited[now - 1]) {
                    q.add(now - 1);
                    visited[now - 1] = true;
                }
                if(now * 2 <= 100000 && !visited[now * 2]) {
                    q.add(now * 2);
                    visited[now * 2] = true;
                }
            }
            cnt++;
        }
        return 0;
    }
}
