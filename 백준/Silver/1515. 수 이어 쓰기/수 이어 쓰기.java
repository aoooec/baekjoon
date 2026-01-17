import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = 0;
        int idx = 0;

        while (idx < input.length()) {
            n++;
            String curr = String.valueOf(n);

            for (int i = 0; i < curr.length() && idx < input.length(); i++) {
                if (curr.charAt(i) == input.charAt(idx)) idx++;
            }
        }

        System.out.print(n);
    }
}
