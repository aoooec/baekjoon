import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        int max = nums[N-1];

        for(int i = N - 2; i >= 0; i--) {
            if(max < nums[i]) {
                count++;
                max = nums[i];
            }
        }

        System.out.println(count);
    }
}