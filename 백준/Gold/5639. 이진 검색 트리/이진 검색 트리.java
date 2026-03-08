import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> pre = new ArrayList<>();
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null && !s.isEmpty()) {
            pre.add(Integer.parseInt(s));
        }

        postOrder(Integer.MAX_VALUE);
        System.out.print(sb);
    }

    static void postOrder(int upperbound) {
        if (idx >= pre.size()) return;

        int root = pre.get(idx);
        if (root > upperbound) return;

        idx++;
        postOrder(root);
        postOrder(upperbound);
        sb.append(root).append('\n');
    }
}