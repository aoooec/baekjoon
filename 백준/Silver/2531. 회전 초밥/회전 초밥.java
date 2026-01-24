import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) belt[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            int sushi = belt[i];
            if (cnt[sushi] == 0) distinct++;
            cnt[sushi]++;
        }

        int answer = distinct + (cnt[c] == 0 ? 1 : 0);

        for (int start = 1; start < N; start++) {
            int out = belt[start - 1];
            cnt[out]--;
            if (cnt[out] == 0) distinct--;

            int idx = (start + k - 1) % N;
            int in = belt[idx];
            if (cnt[in] == 0) distinct++;
            cnt[in]++;

            int curr = distinct + (cnt[c] == 0 ? 1 : 0);
            answer = Math.max(answer, curr);
        }

        System.out.print(answer);
    }
}