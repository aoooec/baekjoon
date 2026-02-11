import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] weights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int w : weights) {
            boolean[] next = dp.clone();
            ArrayList<Integer> nList = new ArrayList<>(list);

            for (int d : list) {
                int plus = d + w;
                if (plus <= sum && !next[plus]) {
                    next[plus] = true;
                    nList.add(plus);
                }

                int diff = Math.abs(d - w);
                if (!next[diff]) {
                    next[diff] = true;
                    nList.add(diff);
                }
            }

            dp = next;
            list = nList;
        }

        int B = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append((num <= sum && dp[num]) ? 'Y' : 'N').append(' ');
        }

        System.out.print(sb);
    }
}