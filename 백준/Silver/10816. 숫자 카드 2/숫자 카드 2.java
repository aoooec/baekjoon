import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> count = new HashMap<>(N * 2);
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(count.getOrDefault(number, 0)).append(" ");
        }
        System.out.print(sb);
    }
}
