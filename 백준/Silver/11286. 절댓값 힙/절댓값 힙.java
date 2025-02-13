import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ppq = new PriorityQueue<>(); // 양수는 이곳에, 최소힙
        PriorityQueue<Integer> npq = new PriorityQueue<>(Collections.reverseOrder()); // 음수는 이곳에, 최대힙

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine()); // int형 범위의 값(-2^31 ~ 2^31)

            if(x == 0) {
                int p = 0;
                int n = 0;
                if(!ppq.isEmpty()) p = ppq.peek();
                if(!npq.isEmpty()) n = -npq.peek();

                if(p != 0 && n != 0) {
                    if(p == n) sb.append(npq.poll());
                    else if(p > n) sb.append(npq.poll());
                    else sb.append(ppq.poll());
                } else if(n == 0 && p != 0) sb.append(ppq.poll());
                else if(n != 0 && p == 0) sb.append(npq.poll());
                else sb.append(0);

                sb.append('\n');
            } else {
                if (x < 0) npq.add(x);
                else ppq.add(x);
            }
        }
        System.out.print(sb.toString());
    }
}