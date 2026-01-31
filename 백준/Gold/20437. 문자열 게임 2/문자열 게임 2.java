import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

            for (int i = 0; i < W.length(); i++) {
                pos[W.charAt(i) - 'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (ArrayList<Integer> list : pos) {
                if (list.size() < K) continue;

                for (int i = 0; i + K - 1 < list.size(); i++) {
                    int length = list.get(i + K - 1) - list.get(i) + 1;
                    if (length < min) min = length;
                    if (length > max) max = length;
                }
            }

            if (max == -1) sb.append("-1\n");
            else sb.append(min).append(' ').append(max).append('\n');
        }

        System.out.print(sb);
    }
}