import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int curr = Integer.parseInt(st.nextToken());
        int ans = curr;

        for (int i = 1; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            curr = Math.max(curr + x, x);
            ans = Math.max(curr, ans);
        }

        System.out.print(ans);
    }
}