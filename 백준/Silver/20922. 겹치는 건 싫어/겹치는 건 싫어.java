import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0;
        int max = 0;

        for (int right = 0; right < N; right++) {
            int x = arr[right];
            cnt[x]++;

            while (cnt[x] > K) {
                cnt[arr[left]]--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.print(max);
    }
}
