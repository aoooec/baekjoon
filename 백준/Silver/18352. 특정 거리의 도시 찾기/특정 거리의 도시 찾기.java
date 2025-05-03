import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 300000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 도시 수, 2~300000
        int M = Integer.parseInt(st.nextToken()); // 도로 수, 1~100000
        int K = Integer.parseInt(st.nextToken()); // 찾아야하는 두 도시 간 거리, 1~300000
        int X = Integer.parseInt(st.nextToken()); // 출발 도시, 1~N
        int[] dist = new int[N+1]; // 도시는 1번부터 시작
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges.get(A).add(B); // 단방향
        }

        Arrays.fill(dist, INF); // 최댓값 + 1
        dist[X] = 0; // 자기 자신

        Queue<Integer> q = new ArrayDeque<>(); // 모든 거리가 1 -> PQ 사용할 필요 x (순차적)
        q.add(X);
        while(!q.isEmpty()) {
            int tmp = q.poll();
            if(dist[tmp] + 1 > K) break;
            for(int next: edges.get(tmp)) { // 연결된 간선 도착지를 찾아서
                if(dist[next] > dist[tmp] + 1) {  // 기존 거리가 지금보다 큰 경우
                    dist[next] = dist[tmp] + 1; // 갱신 (작은값으로)
                    q.add(next);
                }
            }
        }
        boolean isFound = false;
        for(int i = 1; i <= N; i++) { // 오름차순
            if(dist[i] == K) { // 거리가 정확히 일치하는 경우
                System.out.println(i);
                isFound = true; // 플래그 변경
            }
        }
        if(!isFound) System.out.print(-1); // 일치하는 경우가 없으면 -1
    }
}