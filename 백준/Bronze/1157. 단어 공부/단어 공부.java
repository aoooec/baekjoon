import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] count = new int[26];
        int max = 0;
        int maxIdx = -1;
        boolean isDup = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int idx = -1;

            if (c >= 'a' && c <= 'z') {
                idx = c - 'a';
            } else {
                idx = c - 'A';
            }

            int curr = ++count[idx];
            if (curr > max) {
                max = curr;
                maxIdx = idx;
                isDup = false;
            } else if (curr == max) {
                isDup = true;
            }
        }

        System.out.print(isDup ? "?" : (char)('A' + maxIdx));
    }
}
