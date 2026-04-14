import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        boolean[] trace = new boolean[N + 1];
        for (int start = 1; start <= N; start++) {
            int cur = start;
            boolean[] visited = new boolean[N + 1];
            while (!visited[cur]) {
                visited[cur] = true;
                cur = nums[cur];
            }
            if (start == cur) {
                for (int i = 1; i <= N; i++) {
                    if (visited[i] && !trace[i]) {
                        trace[i] = true;
                        ans++;
                    }
                }
            }
        }

        sb.append(ans).append('\n');
        for (int i = 1; i <= N; i++) {
            if (trace[i]) sb.append(i).append('\n');
        }

        System.out.print(sb);
    }
}