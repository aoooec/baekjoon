import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 시험장 수, 1~1000000
        int[] candidates = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken()); // 총 감독관이 감시할 수 있는 수
        int C = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 수
        long ans = 0;
        for(int candidate: candidates) {
            ans += 1;
            int rest = candidate - B;
            if(rest > 0) ans += (rest + C - 1) / C;
        }
        System.out.print(ans);
    }
}