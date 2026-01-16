import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int size = 2 * N;
        int[] durability = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) durability[i] = Integer.parseInt(st.nextToken());

        boolean[] robot = new boolean[N];

        int step = 0;
        int zero = 0;
        while (true) {
            step++;

            int last = durability[size - 1];
            for (int i = size - 1; i >= 1; i--) durability[i] = durability[i - 1];
            durability[0] = last;

            for (int i = N - 1; i >= 1; i--) robot[i] = robot[i - 1];
            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 2; i >= 0; i--) {
                if (!robot[i]) continue;
                if (robot[i + 1]) continue;
                if (durability[i + 1] <= 0) continue;

                robot[i] = false;
                robot[i + 1] = true;
                durability[i + 1]--;
                if (durability[i + 1] == 0) zero++;
            }
            robot[N - 1] = false;

            if (durability[0] > 0 && !robot[0]) {
                robot[0] = true;
                durability[0]--;
                if (durability[0] == 0) zero++;
            }

            if (zero >= K) {
                System.out.print(step);
                return;
            }
        }
    }
}
