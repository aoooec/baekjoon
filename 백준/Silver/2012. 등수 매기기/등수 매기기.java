import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        long ans = 0;
        for(int i = 0; i < N; i++) {
            int diff = Math.abs(array[i] - (i + 1));
            ans += diff;
        }
        System.out.print(ans);
    }
}
