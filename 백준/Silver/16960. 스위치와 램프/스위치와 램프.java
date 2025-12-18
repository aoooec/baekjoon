import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] deg = new int[M + 1];
        int[] unique = new int[M + 1]; // 스위치 번호(유일)
        boolean[] must = new boolean[N + 1]; // 반드시 켜야 하는지 여부

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                if (deg[lamp] == 0) {
                    unique[lamp] = i;
                }
                deg[lamp]++;
            }
        }

        for (int i = 1; i <= M; i++) {
            if (deg[i] == 1) {
                must[unique[i]] = true;
            }
        }

        if (N == 1) {
            System.out.print(0);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!must[i]) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }
}
