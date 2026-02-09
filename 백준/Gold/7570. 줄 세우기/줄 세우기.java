import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] pos = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            pos[num] = i;
        }

        int maxL = 1;
        int curr = 1;

        for (int i = 2; i <= N; i++) {
            if (pos[i] > pos[i - 1]) curr++;
            else curr = 1;

            if (curr > maxL) maxL = curr;
        }

        System.out.print(N - maxL);
    }
}