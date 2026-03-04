import java.io.*;
import java.util.*;

public class Main {
    static class Word {
        String s;
        int idx;

        Word(String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] original = new String[N];
        Word[] words = new Word[N];

        for (int i = 0; i < N; i++) {
            original[i] = br.readLine();
            words[i] = new Word(original[i], i);
        }

        Arrays.sort(words, (a, b) -> a.s.compareTo(b.s));

        int bestL = 0;
        for (int i = 0; i < N - 1; i++) {
            bestL = Math.max(bestL, lcp(words[i].s, words[i + 1].s));
        }

        if (bestL == 0) {
            System.out.print(original[0] + '\n' + original[1]);
            return;
        }

        HashMap<String, int[]> map = new HashMap<>();

        for (Word w : words) {
            if (w.s.length() < bestL) continue;
            String key = w.s.substring(0, bestL);
            int[] best = map.get(key);
            if (best == null) {
                best = new int[]{w.idx, Integer.MAX_VALUE};
                map.put(key, best);
            } else {
                int x = w.idx;
                if (x < best[0]) {
                    best[1] = best[0];
                    best[0] = x;
                } else if (x < best[1]) {
                    best[1] = x;
                }
            }
        }

        int ansS = Integer.MAX_VALUE;
        int ansT = Integer.MAX_VALUE;
        for (int[] best : map.values()) {
            if (best[1] == Integer.MAX_VALUE) continue;
            int s = best[0];
            int t = best[1];
            if (s < ansS || (s == ansS && t < ansT)) {
                ansS = s;
                ansT = t;
            }
        }

        System.out.print(original[ansS] + '\n' + original[ansT]);
    }

    static int lcp(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }
}