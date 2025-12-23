import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] controller = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                controller[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            int length = pressNumCnt(i);
            if (length == -1) continue;

            int pressCnt = length + Math.abs(N - i);
            min = Math.min(pressCnt, min);
        }

        System.out.print(min);
    }

    static int pressNumCnt(int x) {
        if (x == 0) return controller[0] ? -1 :1;

        int length = 0;
        while (x > 0) {
            int d = x % 10;
            if (controller[d]) return -1;
            length++;
            x /= 10;
        }
        return length;
    }
}
