import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] req = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i = 0; i < N; i++) {
            req[i] = Integer.parseInt(st.nextToken());
            if(req[i] > max) max = req[i];
        }
        int M = Integer.parseInt(br.readLine());
        int low = 0;
        int high = max;
        int res = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for (int r: req) {
                sum += Math.min(r, mid);
            }
            if(sum <= M) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(res);
    }
}