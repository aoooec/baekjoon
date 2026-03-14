import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int fc = n / 5;

        while (fc >= 0) {
            int remain = n - fc * 5;

            if (remain % 2 == 0) {
                int tc = remain / 2;
                System.out.print(fc + tc);

                return;
            }

            fc--;
        }

        System.out.print(-1);
    }
}