import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double ming = -1_000_000_000;
            for (int j = i - 1; j >= 0; j--) {
                double g = (double)(buildings[j] - buildings[i]) / (i - j);
                if (g <= ming) continue;
                ming = g;
                cnt++;
            }
            ming = -1_000_000_000;
            for (int j = i + 1; j < N; j++) {
                double g = (double)(buildings[j] - buildings[i]) / (j - i);
                if (g <= ming) continue;
                ming = g;
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}