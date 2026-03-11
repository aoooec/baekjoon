import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] taller = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            taller[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();

        for (int i = N; i >= 1; i--) {
            line.add(taller[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int h : line) {
            sb.append(h).append(' ');
        }

        System.out.print(sb);
    }
}