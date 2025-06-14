import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, M, adjCnt, ans;
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjCnt = N + M + 1;
        adj = new ArrayList[adjCnt];
        visited = new boolean[adjCnt];
        for(int i = 1; i < adjCnt; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                adj[num].add(N+i); // 역에 하이퍼튜브 연결
                adj[N+i].add(num); // 하이퍼튜브에 역 연결
            }
        }
        ans = -1;
        bfs();
        System.out.print(ans);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{1, 1});
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int num = tmp[0];
            int lv = tmp[1];
            if(num == N) {
                ans = lv;
                return;
            }
            for(int i = 0; i < adj[num].size(); i++) {
                int hyper = adj[num].get(i);
                if(visited[hyper]) continue;
                visited[hyper] = true;
                for(int station: adj[hyper]) {
                    if(visited[station]) continue;
                    q.add(new int[]{station, lv + 1});
                    visited[station] = true;
                }
            }
        }
    }
}