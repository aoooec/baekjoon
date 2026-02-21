import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long high = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i]);
        }

        long low = 1;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (long x : arr) {
                cnt += (x / mid);
                if (cnt >= N) break;
            }

            if (cnt >= N) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.print(ans);
    }
}