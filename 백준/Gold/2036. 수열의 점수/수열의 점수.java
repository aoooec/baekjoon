import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int oneCnt = 0;
        int zeroCnt = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 1) plus.add(x);
            else if (x == 1) oneCnt++;
            else if (x == 0) zeroCnt++;
            else minus.add(x);
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        long ans = oneCnt;

        for (int i = 0; i + 1 < plus.size(); i += 2) {
            ans += (long) plus.get(i) * plus.get(i + 1);
        }
        if (plus.size() % 2 == 1) {
            ans += plus.get(plus.size() - 1);
        }
        for (int i = 0; i + 1 < minus.size(); i += 2) {
            ans += (long) minus.get(i) * minus.get(i + 1);
        }
        if (minus.size() % 2 == 1 && zeroCnt == 0) {
            ans += minus.get(minus.size() - 1);
        }

        System.out.print(ans);
    }
}