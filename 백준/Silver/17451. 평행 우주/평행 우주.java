import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long speed = arr[N];
        for(int i = N - 1; i > 0; i--) {
            speed = ((speed + arr[i] - 1) / arr[i]) * arr[i];
        }
        System.out.print(speed);
    }
}
