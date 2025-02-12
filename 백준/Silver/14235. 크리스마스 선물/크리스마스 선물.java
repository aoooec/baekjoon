import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 0) {
                sb.append(heap.isEmpty() ? -1 : heap.poll()).append("\n");
            } else {
                for (int i = 0; i < a; i++) {
                    heap.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb.toString());
    }
}