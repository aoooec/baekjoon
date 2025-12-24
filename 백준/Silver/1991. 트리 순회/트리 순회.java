import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] tree = new char[26][2];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left   = st.nextToken().charAt(0);
            char right  = st.nextToken().charAt(0);

            int idx = parent - 'A';
            tree[idx][0] = left;
            tree[idx][1] = right;
        }

        dfs(0);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void dfs(int idx) {
        pre.append((char)(idx + 'A'));

        if (tree[idx][0] != '.') {
            dfs(tree[idx][0] - 'A');
        }

        in.append((char)(idx + 'A'));

        if (tree[idx][1] != '.') {
            dfs(tree[idx][1] - 'A');
        }

        post.append((char)(idx + 'A'));
    }
}
