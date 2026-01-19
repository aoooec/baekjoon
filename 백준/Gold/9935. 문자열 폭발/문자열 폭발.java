import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] bomb = br.readLine().toCharArray();

        int n = input.length();
        int m = bomb.length;
        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            stack[top++] = input.charAt(i);

            if (top >= m && stack[top - 1] == bomb[m - 1]) {
                boolean ok = true;
                for (int j = 0; j < m; j++) {
                    if (stack[top - m + j] != bomb[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) top -= m;
            }
        }

        System.out.print(top == 0 ? "FRULA" : new String(stack, 0, top));
    }
}