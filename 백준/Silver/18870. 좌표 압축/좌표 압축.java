import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] orderedNums = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            orderedNums[i] = nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(orderedNums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(orderedNums[i])) {
                map.put(orderedNums[i], cnt++);
            }
        }
        for(int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }
        System.out.print(sb.toString());
    }
}