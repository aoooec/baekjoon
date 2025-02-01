import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        for (int i = N / 5; i >= 0; i--) {
            int remains = N - (5 * i);
            if (remains % 3 == 0) {
                int total = i + (remains / 3);
                min = Math.min(min, total);
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}