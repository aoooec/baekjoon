import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 0; tc < P; tc++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            int[] line = new int[20];
            for (int i = 0; i < 20; i++) line[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = i + 1; j < 20; j++) {
                    if (line[i] > line[j]) cnt++;
                }
            }

            sb.append(T).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
