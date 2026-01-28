import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int left = 0; int right = N - 1;
            long target = arr[i];

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right];
                if (sum == target) {
                    ans++;
                    break;
                } else if (sum < target) left++;
                else right--;
            }
        }

        System.out.print(ans);
    }
}