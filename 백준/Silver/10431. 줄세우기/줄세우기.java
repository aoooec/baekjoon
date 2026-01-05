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
            int cnt = 0;

            for (int len = 0; len < 20; len++) {
                int h = Integer.parseInt(st.nextToken());

                int pos = 0;
                while (pos < len && line[pos] < h) pos++;

                cnt += (len - pos);

                for (int j = len; j > pos; j--) {
                    line[j] = line[j - 1];
                }
                line[pos] = h;
            }

            sb.append(T).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
