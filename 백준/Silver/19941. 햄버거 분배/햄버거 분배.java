import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] != 'P') continue;

            idx = Math.max(idx, i - K);
            int right = Math.min(N - 1, i + K);

            for (; idx <= right; idx++) {
                if (arr[idx] == 'H') {
                    cnt++;
                    idx++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }
}
