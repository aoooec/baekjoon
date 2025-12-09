import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int cnt = N;
        int answer = 0;
        for(int i = min; i < max && cnt > 0; i++) {
            int cur = arr[i];
            if(cur == 0) continue;
            answer = Math.max(answer, cnt * i);
            cnt -= cur;
        }
        System.out.print(answer);
    }
}
