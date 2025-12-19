import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX_CNT = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        int sIdx = 0, min = MAX_CNT, sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
            sum += num;

            while (sum >= S) {
                min = Math.min(min, i - sIdx + 1);
                sum -= array[sIdx++];
            }

            if (min == 1) break;
        }

        System.out.print(min == MAX_CNT ? 0 : min);
    }
}
