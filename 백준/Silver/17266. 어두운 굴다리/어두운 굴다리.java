import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int s = 0;
        int prev = 0;
        int maxH = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int curr = Integer.parseInt(st.nextToken());

            if (i == 0) {
                s = curr;

            } else {
                maxH = Math.max((curr - prev + 1) / 2, maxH);
            }

            prev = curr;
        }

        maxH = Math.max(maxH, Math.max(N - prev, s));

        System.out.print(maxH);
    }
}
