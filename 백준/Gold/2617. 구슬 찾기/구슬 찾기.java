import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 1~99
        int M = Integer.parseInt(st.nextToken()); // 1~N(N-1)/2
        int mid = N/2;
        boolean[][] graph = new boolean[N+1][N+1]; // [0]이 [1]보다 무거울 경우 true

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 더 무거운 구슬
            int b = Integer.parseInt(st.nextToken()); // 더 가벼운 구슬
            graph[a][b] = true;
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k == i) continue;
                for(int j = 1; j <= N; j++) {
                    if(k == j || i == j) continue;
                    // 중간 지점이 있는 경우 -> i > j도 성립
                    if(graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
        int cnt = 0; // 정답 개수 (중간이 될 수 없는 구슬의 수)
        for(int i = 1; i <= N; i++) {
            int heavy = 0; // i보다 무거운 구슬의 수
            int light = 0; // i보다 가벼운 구슬의 수 
            for(int j = 1; j <= N; j++) {
                if(graph[i][j]) light++;
                else if (graph[j][i]) heavy++;
            }
            // 조건: 모양은 같으나 무게가 모두 다른 N개의 구슬
            // 나보다 큰 or 작은 노드의 개수 > N / 2
            // 이 수가 확정적인 노드가 중간이 될 가능성이 전혀 없는 구슬
            if(light > mid || heavy > mid) cnt++;
        }
        System.out.print(cnt);
    }
}