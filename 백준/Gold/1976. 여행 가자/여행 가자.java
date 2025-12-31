import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int root = find(first);

        for (int i = 1; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (find(v) != root) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}
