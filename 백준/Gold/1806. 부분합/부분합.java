import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());

        int sIdx = 0, min = Integer.MAX_VALUE, sum = 0;

        for (int right = 0; right < N; right++) {
            sum += array[right];

            while (sum >= S) {
                min = Math.min(min, right - sIdx + 1);
                sum -= array[sIdx++];
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }
}
