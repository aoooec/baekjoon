import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, ans;
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 2~500, 동기의 수
        m = Integer.parseInt(br.readLine()); // 1~10000, 리스트의 길이
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        bfs();
        System.out.print(ans);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<Integer>();
        int level = 0;
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            if(level > 2) break;
            for(int i = 0; i < size; i++) {
                int tmp = q.poll();
                for(int f: adj[tmp]) {
                   if(visited[f]) continue;
                   q.add(f);
                   visited[f] = true;
                   ans++;
                }
            }
        }
    }
}