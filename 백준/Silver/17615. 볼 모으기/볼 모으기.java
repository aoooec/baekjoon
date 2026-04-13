import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int totalR = 0;
        int totalB = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') totalR++;
            else totalB++;
        }

        int leftR = 0;
        while (leftR < N && s.charAt(leftR) == 'R') leftR++;

        int rightR = 0;
        while (rightR < N && s.charAt(N - 1 - rightR) == 'R') rightR++;

        int leftB = 0;
        while (leftB < N && s.charAt(leftB) == 'B') leftB++;

        int rightB = 0;
        while (rightB < N && s.charAt(N - 1 - rightB) == 'B') rightB++;

        int ans = Math.min(totalR - Math.max(leftR, rightR),
                totalB - Math.max(leftB, rightB));

        System.out.print(ans);
    }
}