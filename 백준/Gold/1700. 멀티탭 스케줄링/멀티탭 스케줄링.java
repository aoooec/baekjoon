import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 1~100
        int K = Integer.parseInt(st.nextToken()); // 1~100
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int[] order = new int[K];
        int change = 0; // 변경 횟수
        int[] tap = new int[N]; // 멀티탭
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.putIfAbsent(num, new PriorityQueue<>());
            map.get(num).add(i);
            order[i] = num;
        }
a:      for(int i = 0; i < K; i++) {
            for(int d: tap) {
                if(d == order[i]) { // 탭에 이미 꽂혀있는 경우
                    map.get(order[i]).poll();
                    continue a;
                }
            }
            for(int j = 0; j < N; j++) {
                if(tap[j] == 0) {
                    tap[j] = order[i];
                    map.get(order[i]).poll();
                    continue a;
                }
            }

            int rIdx = -1; // 교체 인덱스
            int latest = -1; // 꽂힌 것 중 가장 뒤에 사용되는 번호
            for(int j = 0; j < N; j++) {
                int device = tap[j];
                if(map.get(device).isEmpty()) { // 다음에 쓰이지 않는 기기이면
                    rIdx = j;
                    break; // 탐색 중단, 바로 교체
                } else {
                    int next = map.get(device).peek(); // 다음에 사용될 인덱스
                    if(next > latest) { // 이게 더 늦게 사용되는 거면
                        latest = next; // 교체해야할 번호를 바꿈
                        rIdx = j;
                    }
                }
            }
            tap[rIdx] = order[i];
            change++;
            map.get(order[i]).poll();
        }
        System.out.print(change);
    }
}