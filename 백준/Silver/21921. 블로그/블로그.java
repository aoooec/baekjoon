import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int sum = 0, max = 0, cnt = 0, left = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i < X) sum += arr[i];
            else sum = sum - arr[left++] + arr[i];

            if (sum > max) {
                cnt = 1;
                max = sum;
            } else if (sum != 0 && sum == max) {
                cnt++;
            }
        }

        if (max == 0) System.out.print("SAD");
        else System.out.print(max + "\n" + cnt);
    }
}
