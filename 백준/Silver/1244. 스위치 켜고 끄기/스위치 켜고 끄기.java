import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] switches = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken()) != 0;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int mul = number; mul <= N; mul += number) {
                    switches[mul] = !switches[mul];
                }
            } else {
                int left = number;
                int right = number;

                while (left - 1 >= 1 && right + 1 <= N && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                }

                for (int x = left; x <= right; x++) {
                    switches[x] = !switches[x];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
