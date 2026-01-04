import java.io.*;
import java.util.*;

public class Main {
    static void swap(List<String> a, int i, int j) {
        String t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    static int find(List<String> a, String target) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<String> ch = new ArrayList<>(N);
        for (int i = 0; i < N; i++) ch.add(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        int pos = 0;

        int idx1 = find(ch, "KBS1");

        while (pos < idx1) {
            sb.append('1');
            pos++;
        }

        while (idx1 > 0) {
            swap(ch, idx1, idx1 - 1);
            sb.append('4');
            idx1--;
            pos--;
        }

        int idx2 = find(ch, "KBS2");

        while (pos < idx2) {
            sb.append('1');
            pos++;
        }

        while (idx2 > 1) {
            swap(ch, idx2, idx2 - 1);
            sb.append('4');
            idx2--;
            pos--;
        }

        System.out.print(sb.toString());
    }
}
