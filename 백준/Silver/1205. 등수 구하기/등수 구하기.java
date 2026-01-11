import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.print(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int greater = 0;
        int last = -1;

        for (int i = 0; i < N; i++) {
            int s = Integer.parseInt(st.nextToken());
            last = s;
            if (s > T) greater++;
        }

        if (N == P && T <= last) {
            System.out.print(-1);
            return;
        }

        System.out.print(greater + 1);
    }
}
