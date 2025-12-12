import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
            B.add(Integer.parseInt(st2.nextToken()));
        }
        int sum = 0;
        while(!A.isEmpty() && !B.isEmpty()) {
            sum += A.poll() * B.poll();
        }
        System.out.print(sum);
    }
}
