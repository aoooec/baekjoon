import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static char[][] tree;
    static Map<Character, Integer> idxMap = new HashMap<>();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new char[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken().charAt(0);
            tree[i][1] = st.nextToken().charAt(0);
            tree[i][2] = st.nextToken().charAt(0);
            idxMap.put(tree[i][0], i);
        }

        int root = idxMap.get('A');
        preorder(root);
        inorder(root);
        postorder(root);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(int i) {
        pre.append(tree[i][0]);
        char l = tree[i][1];
        if (l != '.') preorder(idxMap.get(l));
        char r = tree[i][2];
        if (r != '.') preorder(idxMap.get(r));
    }

    static void inorder(int i) {
        char l = tree[i][1];
        if (l != '.') inorder(idxMap.get(l));
        in.append(tree[i][0]);
        char r = tree[i][2];
        if (r != '.') inorder(idxMap.get(r));
    }

    static void postorder(int i) {
        char l = tree[i][1];
        if (l != '.') postorder(idxMap.get(l));
        char r = tree[i][2];
        if (r != '.') postorder(idxMap.get(r));
        post.append(tree[i][0]);
    }
}
