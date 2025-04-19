import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~50
        int dasom = Integer.parseInt(br.readLine()); // 다솜
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int temp = pq.poll();
            temp--;
            dasom++;
            cnt++;
            pq.add(temp);
        }
        System.out.print(cnt);
    }
}