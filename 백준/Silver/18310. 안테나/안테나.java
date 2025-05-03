import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~200000
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] list = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // 1~100000
        }
        Arrays.sort(list);
        System.out.print(list[(N-1)/2]);
    }
}