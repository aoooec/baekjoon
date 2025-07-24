import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[] condition;
    static boolean[] selected, ans;
    static int[][] items;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        condition = new int[4];
        selected = new boolean[N + 1]; // 0번 인덱스 버림
        ans = new boolean[N + 1];
        items = new int[N + 1][5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, new int[4], 0);

        if(min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        sb.append(min).append("\n");
        for(int i = 1; i <= N; i++) {
            if(ans[i]) sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int idx, int[] tmp, int sum) {
        if(sum >= min) return;
        boolean isOk = true;
        for(int i = 0; i < 4; i++) {
            if(tmp[i] < condition[i]) {
                isOk = false;
                break;
            }
        }
        if(isOk) {
            ans = selected.clone();
            min = sum;
            return;
        }
        int[] next = new int[4];
        for(int i = idx + 1; i <= N; i++) {
            selected[i] = true;
            for(int j = 0; j < 4; j++) {
                next[j] = tmp[j] + items[i][j];
            }
            dfs(i, next, sum + items[i][4]);
            selected[i] = false;
        }
    }
}
