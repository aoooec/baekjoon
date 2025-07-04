import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        for(int i = 0; i < N; i++) {
            nums[i] = br.readLine();
        }
        int len = nums[0].length();
        for(int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            for(String num: nums) {
                set.add(num.substring(len - i));
            }
            if(set.size() == N) {
                System.out.print(i);
                break;
            }
        }
    }
}