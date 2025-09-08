import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) truck[i] = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        int idx = 0, time = 0, sum = 0;
        while(true) {
            time++;
            if(q.size() == w) sum -= q.poll();
            if(idx == n && sum == 0) break;
            if(idx < n && sum + truck[idx] <= L) {
                q.add(truck[idx]);
                sum += truck[idx++];
            } else q.add(0);
        }
        System.out.print(time);
    }
}
