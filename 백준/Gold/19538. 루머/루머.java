import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 사람 수 1~200000

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>(); // 사람 수 만큼의 리스트 생성
        }

        for (int i = 1; i <= N; i++) {
            // 관계 채우기
            st = new StringTokenizer(br.readLine().trim(), " ");
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) break; // 입력 종료
                adj[i].add(x); // 일방적인 관계 없음 -> 무향이지만 하나만 채우기
            }
        }

        int[] time = new int[N + 1]; // 루머를 믿은 시간
        int[] cnt = new int[N + 1]; // 주변인 총 수
        int[] minCnt = new int[N + 1]; // 최소 카운트 (주변인 절반 이상)
        int[] now = new int[N + 1]; // 주변인 중 현재까지 루머를 믿는 사람 수

        Arrays.fill(time, -1); // 믿지 않는 상태로 시작

        for (int i = 1; i <= N; i++) {
            cnt[i] = adj[i].size(); // 주변인이 총 몇명인지
            minCnt[i] = (cnt[i] + 1) / 2;  // 해당 값을 기반으로 필요한 루머를 믿는 최소 인원 수
        }

        int M = Integer.parseInt(br.readLine()); // 1~N, 최초 루머 유포자
        st = new StringTokenizer(br.readLine().trim(), " ");

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            time[num] = 0;
            q.add(num); // 최초 유포자를 큐에 넣고, 믿은 시간을 0으로 세팅
        }

        while (!q.isEmpty()) {
            int u = q.poll(); // 이미 믿고 있는 사람

            for (int p : adj[u]) {
                if (time[p] == -1) { // 아직 안믿는 상태
                    now[p]++; // 믿는 주변인 수를 늘리기

                    if (now[p] >= minCnt[p]) { // 최소 사람 수를 넘기면 자신도 믿게 됨
                        time[p] = time[u] + 1;
                        q.add(p); // 루머 유포자 ㄱ
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(time[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}