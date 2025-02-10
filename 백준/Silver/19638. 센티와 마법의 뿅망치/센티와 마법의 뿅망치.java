import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            maxHeap.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        int max = 0;
        for(int i = 0; i < T; i++) {
            if(maxHeap.isEmpty()) break;

            max = maxHeap.poll();

            if(H > max) {
                maxHeap.add(max);
                break;
            }

            if(max != 1) max /= 2;
            maxHeap.add(max);
            count++;
        }

        if(!maxHeap.isEmpty()) {
            max = maxHeap.peek();
        }

        if(H > max) {
            bw.write("YES\n"+ count);
        } else {
            bw.write("NO\n"+ max);
        }
        bw.flush();
    }
}