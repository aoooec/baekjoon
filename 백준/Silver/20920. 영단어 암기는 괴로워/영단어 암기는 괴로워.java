import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int frequency = map.get(o2).compareTo(map.get(o1));

                if (frequency != 0) return frequency;

                int length = o1.length() - o2.length();

                if (length != 0) return length < 0 ? 1 : -1;

                for (int i = 0; i < o1.length(); i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);

                    if (c1 != c2) return c1 > c2 ? 1: -1;
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keySet.size(); i++) {
            sb.append(keySet.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}
