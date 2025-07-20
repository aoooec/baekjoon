import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());             // 1~50
        int M = Integer.parseInt(st.nextToken());             // 1~50
        List<Integer> neg = new ArrayList<Integer>();         // 좌표 중 음수만 저장
        List<Integer> pos = new ArrayList<Integer>();         // 좌표 중 양수만 저장
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());         // -100000~100000
            if(x < 0) neg.add(Math.abs(x));
            else if(x > 0) pos.add(x);
        }
        Collections.sort(neg, Collections.reverseOrder());    // 내림차순 정렬
        Collections.sort(pos, Collections.reverseOrder());
        int dist = 0;
        if(!neg.isEmpty() && (pos.isEmpty() || neg.get(0) > pos.get(0))) {
            // 가장 멀리 있는 책 위치를 찾아 편도 처리하고, M개만큼을 리스트에서 제외함
            dist = neg.get(0);
            neg = (neg.size() >= M ? neg.subList(M, neg.size()) : new ArrayList<>());
        } else if (!pos.isEmpty()) {
            dist = pos.get(0);
            pos = (pos.size() >= M ? pos.subList(M, pos.size()) : new ArrayList<>());
        }
        for(int i = 0; i < neg.size(); i += M) {
            dist += neg.get(i) * 2;
        }
        for(int i = 0; i < pos.size(); i += M) {
            dist += pos.get(i) * 2;
        }
        System.out.print(dist);
    }
}