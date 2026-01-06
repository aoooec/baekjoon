import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] h = new int[N + 1];
        int[] idx = new int[N + 1];
        int top = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (top > 0 && h[top] < num) top--;

            sb.append(top == 0 ? 0 : idx[top]).append(" ");

            h[++top] = num;
            idx[top] = i;
        }

        System.out.print(sb);
    }
}
