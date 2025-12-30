import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] children;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        children = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) continue;
            children[parent].add(i);
        }

        System.out.print(dfs(0));
    }

    static int dfs(int root) {
        if (children[root].isEmpty()) return 0;

        List<Integer> times = new ArrayList<>();
        for (int c : children[root]) {
            times.add(dfs(c));
        }

        times.sort(Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1);
        }

        return max;
    }
}
