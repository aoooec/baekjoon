import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] isbn = br.readLine().toCharArray();

        int sum = 0;
        int idx = 0;
        for (int i = 0; i < isbn.length; i++) {
            char c = isbn[i];
            if (c != '*') {
                sum += i % 2 == 0 ? c - '0' : (c - '0') * 3;
            } else {
                idx = i;
            }
        }

        int ans = 0;
        while (true) {
            int num = idx % 2 == 0 ? ans : ans * 3;

            if ((num + sum) % 10 == 0) {
                System.out.print(ans);
                break;
            }

            ans++;
        }
    }
}