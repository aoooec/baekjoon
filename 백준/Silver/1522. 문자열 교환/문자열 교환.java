import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = input.length();
        int a = 0;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == 'a') a++;
        }

        int min = 1000;
        for (int i = 0; i < length; i++) {
            int cnt = 0;
            for (int j = i; j < a + i; j++) {
                if (input.charAt(j % length) == 'b') cnt++;
            }
            min = Math.min(min, cnt);
        }

        System.out.print(min);
    }
}