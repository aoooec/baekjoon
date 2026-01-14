import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> person = new ArrayDeque<>();
        Queue<Integer> hamburger = new ArrayDeque<>();

        String line = br.readLine();

        for (int i = 0; i < N; i++) {
            if (line.charAt(i) == 'H') hamburger.offer(i);
            else person.offer(i);
        }

        int cnt = 0;
        while (!person.isEmpty() && !hamburger.isEmpty()) {
            int pIdx = person.poll();

            while (!hamburger.isEmpty()) {
                int hIdx = hamburger.peek();

                if (Math.abs(pIdx - hIdx) <= K) {
                    cnt++;
                    hamburger.poll();
                    break;
                } else if (hIdx - pIdx > K) {
                    break;
                }

                hamburger.poll();
            }
        }

        System.out.print(cnt);
    }
}
