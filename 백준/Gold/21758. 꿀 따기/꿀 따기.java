import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] prefix = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            prefix[i] = arr[i] + (i == 0 ? 0 : prefix[i - 1]);
        }

        long total = prefix[N - 1];
        long max = 0;

        for (int i = 1; i < N - 1; i++) {
            long right = 2 * total - arr[0] - prefix[i] - arr[i];
            max = Math.max(max, right);
        }

        for (int i = 1; i < N - 1; i++) {
            long left = total - arr[N - 1] + prefix[i - 1] - arr[i];
            max = Math.max(max, left);
        }

        for (int i = 1; i < N - 1; i++) {
            long mid = total + arr[i] - arr[N - 1] - arr[0];
            max = Math.max(max, mid);
        }

        System.out.print(max);
    }
}
