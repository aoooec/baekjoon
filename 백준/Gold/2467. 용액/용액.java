import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;
        int ansL = 0, ansR = 0;
        int absSum = 2_000_000_000;
        while(left < right) {
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);

            if (absSum > abs) {
                absSum = abs;
                ansL = arr[left];
                ansR = arr[right];
            }

            if (sum > 0) right--;
            else left++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansL).append(" ").append(ansR);

        System.out.print(sb);
    }
}