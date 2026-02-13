import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int newA = a + Math.max(max[0], max[1]);
            int newB = b + Math.max(max[0], Math.max(max[1], max[2]));
            int newC = c + Math.max(max[1], max[2]);

            max[0] = newA;
            max[1] = newB;
            max[2] = newC;

            newA = a + Math.min(min[0], min[1]);
            newB = b + Math.min(min[0], Math.min(min[1], min[2]));
            newC = c + Math.min(min[1], min[2]);

            min[0] = newA;
            min[1] = newB;
            min[2] = newC;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.max(max[0], Math.max(max[1], max[2])))
                .append(' ')
                .append(Math.min(min[0], Math.min(min[1], min[2])));

        System.out.print(sb);
    }
}